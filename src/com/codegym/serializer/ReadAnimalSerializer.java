package com.codegym.serializer;

import com.codegym.model.animal.Animal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReadAnimalSerializer {


    private static ReadAnimalSerializer readAnimalSerializer;

    public  static ReadAnimalSerializer getInstanceReadAnimalSerializer(){
        if (readAnimalSerializer == null){
            readAnimalSerializer = new ReadAnimalSerializer();
        }
        return readAnimalSerializer;
    }

    private ReadAnimalSerializer() {
    }




    public void writeToCSV(List<Animal> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("animal.csv"))) {
            writer.println("Id,Name,Species,Weight,size,age,heal,gender,isHungry,cageId,foodPlanQuantity,foodPlanItem,typeAnimal");
            for (Animal obj : objects) {
                    writer.println(obj.getId() + "," +
                            obj.getName() + "," +
                            obj.getSpecies()+ "," +
                            obj.getWeight()+ "," +
                            obj.getSize()+ "," +
                            obj.getAge()+ "," +
                            obj.getHeal()+ "," +
                            obj.getGender()+ "," +
                            obj.isHungry()+ "," +
                            ((obj.getCageId() == null) ? "" :  obj.getCageId())+ "," +
                            ((obj.getFoodPlan() == null) ? "" :  obj.getFoodPlan().getQuantity()) + "," +
                            ((obj.getFoodPlan() == null) ? "" :  obj.getFoodPlan().getFoodItem())+ "," +
                            obj.getTypeAnimal()
                    );

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
