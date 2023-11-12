package com.codegym.model.supply;

import com.codegym.model.supply.enumerations.BuildingMaterialType;
import com.codegym.model.supply.enumerations.FoodType;
import com.codegym.model.supply.enumerations.MedicineType;
import com.codegym.model.supply.types.BuildingMaterialSupply;
import com.codegym.model.supply.types.FoodSupply;
import com.codegym.model.supply.types.MedicineSupply;
public class ConcreteSupplyBuilder implements SupplyBuilder {
    private int supplyId;
    private String name;
    private double pricePerUnit;
    private int quantityAvailable;

    private Enum<?> subtype;

    @Override
    public SupplyBuilder supplyId(int supplyId) {
        this.supplyId = supplyId;
        return this;
    }

    @Override
    public SupplyBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public SupplyBuilder category(SupplyCategory category) {
        if (category == null) {
            throw new IllegalArgumentException("Danh mục cung cấp không hợp lệ.");
        }
        this.subtype = category;
        return this;
    }

    @Override
    public SupplyBuilder pricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        return this;
    }

    @Override
    public SupplyBuilder quantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
        return this;
    }

    @Override
    public Supply build() {
//        return switch ((SupplyCategory) subtype) {
//            case FOOD -> new FoodSupply(supplyId, name, pricePerUnit, quantityAvailable, (FoodType) subtype);
//            case BUILDING_MATERIAL -> new BuildingMaterialSupply(supplyId, name, pricePerUnit, quantityAvailable, (BuildingMaterialType) subtype);
//            case MEDICINE -> new MedicineSupply(supplyId, name, pricePerUnit, quantityAvailable, (MedicineType) subtype);
//            default -> throw new IllegalArgumentException("Invalid supply category");
//        };

        return null;
    }
}
