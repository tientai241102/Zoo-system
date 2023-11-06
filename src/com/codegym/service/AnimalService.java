package com.codegym.service;

import com.codegym.model.animal.Animal;
import com.codegym.repository.AnimalRepository;

import java.util.List;

public class AnimalService {

    private static AnimalService animalService;


    private AnimalRepository animalRepository = new AnimalRepository();
    public  List<Animal> getAnimals(){
        return animalRepository.getAllAnimals();
    }

    public Animal findById(int animalId){
        return animalRepository.findById(animalId);
    }
    public  List<Animal> findByName(String animalName){
        return animalRepository.findByName(animalName);
    }

    public void addAnimal(Animal animal) {
        animalRepository.addAnimal(animal);
    }
    public void updateAnimal(Animal animal) {
        animalRepository.updateAnimal(animal);
    }

    public void removeAnimal(int animalId) {
        animalRepository.removeAnimal(animalId);
    }




}
