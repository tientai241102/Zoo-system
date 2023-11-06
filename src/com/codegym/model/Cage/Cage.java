package com.codegym.model.Cage;

import com.codegym.model.animal.Animal;
import com.codegym.model.Cage.enumerations.CleanlinessEnclosure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cage implements Comparator<Animal> {
    private String name;
    private double area;
    private int maxAnimals;
    Habitat habitat;
    private List<Animal> animals;
    private CleanlinessEnclosure cleanliness;

    public Cage(String name, double area, int maxAnimals) {
        this.name = name;
        this.area = area;
        this.maxAnimals = maxAnimals;
        this.animals = new ArrayList<>();
        this.cleanliness = CleanlinessEnclosure.NORMAL;
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public int getAnimalsPresent() {
        return animals.size();
    }

    public CleanlinessEnclosure getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(CleanlinessEnclosure cleanliness) {
        this.cleanliness = cleanliness;
    }

    public void addAnimal(Animal animal) {
        if (habitat.isCompatible(animal) && !isFull()) {
            animals.add(animal);
        }
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public boolean isEmpty() {
        return animals.isEmpty();
    }

    public String maintain() {
        boolean empty = isEmpty();
        if (empty && getCleanliness() == CleanlinessEnclosure.NEED_CLEANING) {
            setCleanliness(CleanlinessEnclosure.CLEAN);
            return "Chuồng đã được vệ sinh.";
        } else if (!empty) {
            return "Chuồng phải trống để vệ sinh.";
        } else {
            return "Chuồng không cần được vệ sinh.";
        }
    }

    public boolean isFull() {
        return animals.size() >= maxAnimals;
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getAge() - o2.getAge();
    }
}
