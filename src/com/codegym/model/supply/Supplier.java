package com.codegym.model.supply;

import com.codegym.model.person.Owner;

public class Supplier implements SupplierTask {
    private String supplierId;
    private String name;
    private String contactInformation;
    private Owner owner;
    private double inventory; // Số lượng hàng hóa trong kho


    public Supplier(String supplierId, String name, String contactInformation, Owner owner, double inventory) {
        this.supplierId = supplierId;
        this.name = name;
        this.contactInformation = contactInformation;
        this.owner = owner;
        this.inventory = 1000.0; // Giả sử ban đầu có 1000 đơn vị hàng hóa
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public double getInventory() {
        return inventory;
    }

    public void setInventory(double inventory) {
        this.inventory = inventory;
    }

    @Override
    public void supplyGoods(double amount) {
        if (inventory >= amount) {
            inventory -= amount; // Giảm số lượng hàng hóa trong kho
            performTransaction(amount);
            notifyOwner("Cung cấp hàng hóa thành công");
        } else {
            notifyOwner("Không đủ hàng trong kho");
        }
    }

    @Override
    public void performTransaction(double amount) {
        // Logic thực hiện giao dịch mua bán hàng hóa với chủ sở hữu
        // Ví dụ: cập nhật thông tin tài khoản, gửi thông báo, v.v.
        // Sau khi giao dịch, thông báo cho chủ sở hữu
        double transactionAmount = amount * 10.0;
        System.out.println("Thực hiện giao dịch với giá trị: " + transactionAmount);
        owner.receiveTransactionNotification(name, amount);
    }

    @Override
    public void notifyOwner(String message) {
        System.out.println("Thông báo cho chủ sở hữu: " + message);
    }

}
