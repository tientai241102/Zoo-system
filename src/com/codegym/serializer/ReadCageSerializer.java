package com.codegym.serializer;

import com.codegym.model.Cage.AquaticHabitat;
import com.codegym.model.Cage.Aviary;
import com.codegym.model.Cage.Cage;
import com.codegym.model.Cage.TerrestrialHabitat;
import com.codegym.model.animal.Animal;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReadCageSerializer {
    private static ReadCageSerializer readCageSerializer;

    public static ReadCageSerializer getInstanceReadCageSerializer() {
        if (readCageSerializer == null) {
            readCageSerializer = new ReadCageSerializer();
        }
        return readCageSerializer;
    }


    private ReadCageSerializer() {
    }

    public void writeToCSV(List<Cage> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("cage.csv"))) {
            writer.println("CageId,Name,Area,MaxAnimals,Employee Id,Clean liness,Cage Type,Height,Deepness");
            for (Cage obj : objects) {
                if (obj instanceof Aviary) {
                    writer.println(obj.getCageId() + "," +
                            obj.getName() + "," +
                            obj.getArea() + "," +
                            obj.getMaxAnimals() + "," +
                            obj.getEmployeeId() + "," +
                            obj.getCleanliness() + "," +
                            obj.getCageType() + "," +
                            ((Aviary) obj).getHeight() + ","
                    );
                }else if (obj instanceof TerrestrialHabitat) {
                    writer.println(obj.getCageId() + "," +
                            obj.getName() + "," +
                            obj.getArea() + "," +
                            obj.getMaxAnimals() + "," +
                            obj.getEmployeeId() + "," +
                            obj.getCleanliness() + "," +
                            obj.getCageType() + "," +
                            ((TerrestrialHabitat) obj).getHeight() + ","
                    );
                }else {
                    writer.println(obj.getCageId() + "," +
                            obj.getName() + "," +
                            obj.getArea() + "," +
                            obj.getMaxAnimals() + "," +
                            obj.getEmployeeId() + "," +
                            obj.getCleanliness() + "," +
                            obj.getCageType() + "," +
                             " ," +  ((AquaticHabitat) obj).getDeepness());

                }            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
