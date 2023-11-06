package com.codegym.model.Cage;

import com.codegym.model.Cage.enumerations.CleanlinessEnclosure;
import com.codegym.model.animal.Animal;
import com.codegym.model.animal.interfaces.Mammal;
import com.codegym.model.animal.interfaces.TerrestrialAnimal;

public class TerrestrialHabitat extends Cage implements Habitat {
    private final int height;
    private CleanlinessEnclosure cleanlinessRoof;

    public TerrestrialHabitat(String name, double area, int maxAnimals, int height) {
        super(name, area, maxAnimals);
        if (height <= 0) {
            throw new IllegalArgumentException("Chiều cao của chuồng phải lớn hơn 0.");
        }
        this.height = height;
        this.cleanlinessRoof = CleanlinessEnclosure.CLEAN;
    }

    public CleanlinessEnclosure getCleanlinessRoof() {
        return cleanlinessRoof;
    }

    public void setCleanlinessRoof(CleanlinessEnclosure cleanlinessRoof) {
        this.cleanlinessRoof = cleanlinessRoof;
    }

    @Override
    public boolean isCompatible(Animal animal) {
        if (height <= 0) {
            throw new IllegalArgumentException("Chiều cao của chuồng phải lớn hơn 0.");
        }
        return animal instanceof TerrestrialAnimal;
    }
}
