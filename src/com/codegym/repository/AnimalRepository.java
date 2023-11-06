package com.codegym.repository;

import com.codegym.model.animal.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepository {
    private List<Animal> animals;



    public AnimalRepository() {
        this.animals = new ArrayList<>();
    }


    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void removeAnimal(int animalId) {
        animals.removeIf(animal -> animal.getId() == animalId);
    }

    public Animal findById(int animalId) {
        for (Animal animal : animals) {
            if (animal.getId() == animalId) {
                return animal;
            }
        }
        return null;
    }

    public List<Animal> findByName(String name) {
        List<Animal> foundAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                foundAnimals.add(animal);
            }
        }
        return foundAnimals;
    }

    public List<Animal> getAllAnimals() {
        return animals;
    }

    public void updateAnimal(Animal updatedAnimal) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId() == updatedAnimal.getId()) {
                animals.set(i, updatedAnimal);
                return;
            }
        }
    }
}
