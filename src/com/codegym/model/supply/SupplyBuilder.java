package com.codegym.model.supply;

public interface SupplyBuilder {
    SupplyBuilder supplyId(int supplyId);
    SupplyBuilder name(String name);
    SupplyBuilder category(SupplyCategory category);
    SupplyBuilder pricePerUnit(double pricePerUnit);
    SupplyBuilder quantityAvailable(int quantityAvailable);
    Supply build();
}
