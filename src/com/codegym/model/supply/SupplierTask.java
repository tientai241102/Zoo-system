package com.codegym.model.supply;

public interface SupplierTask {
    void supplyGoods(double amount);
    void performTransaction(double amount);
    void notifyOwner(String message);
}
