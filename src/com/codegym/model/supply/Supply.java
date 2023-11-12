package com.codegym.model.supply;

public class Supply {
    private int supplyId;
    private String name;
    private double pricePerUnit;
    private int quantityAvailable;

    public Supply() {
    }

    public Supply(int supplyId, String name, double pricePerUnit, int quantityAvailable) {
        this.supplyId = supplyId;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantityAvailable = quantityAvailable;
    }

    public int getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(int supplyId) {
        this.supplyId = supplyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "supplyId=" + supplyId +
                ", name='" + name + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", quantityAvailable=" + quantityAvailable +
                '}';
    }
}
