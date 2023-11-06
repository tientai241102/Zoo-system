package com.codegym.model.animal;

import com.codegym.model.animal.enumerations.HealAnimals;
import com.codegym.model.animal.enumerations.GenderAnimals;
import com.codegym.model.foodplan.FoodPlan;

import java.io.Serializable;

public abstract class Animal implements Serializable {

    private int id;
    private String name;
    private String species;
    private double weight,size;
    private int age;
    private HealAnimals heal;
    private GenderAnimals gender;
    private boolean isHungry;
    private FoodPlan foodPlan;

    private String typeAnimal;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Animal(int id, String name, String species, double weight, double size, int age, HealAnimals heal, GenderAnimals gender,String typeAnimal) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.weight = weight;
        this.size = size;
        this.age = age;
        this.heal = heal;
        this.gender = gender;
        this.typeAnimal=typeAnimal;
        this.isHungry = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HealAnimals getHeal() {
        return heal;
    }

    public void setHeal(HealAnimals heal) {
        this.heal = heal;
    }
    public void heal() {
        this.heal = HealAnimals.GOOD;
    }
    public GenderAnimals getGender() {
        return gender;
    }

    public void setGender(GenderAnimals gender) {
        this.gender = gender;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public FoodPlan getFoodPlan() {
        return foodPlan;
    }

    public void setFoodPlan(FoodPlan foodPlan) {
        this.foodPlan = foodPlan;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", size=" + size +
                ", age=" + age +
                ", heal=" + heal +
                ", gender=" + gender +
                ", isHungry=" + isHungry +
                ", foodPlan=" + foodPlan +
                ", typeAnimal='" + typeAnimal + '\'' +
                '}';
    }
}
