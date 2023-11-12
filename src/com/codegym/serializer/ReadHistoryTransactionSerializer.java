package com.codegym.serializer;


import com.codegym.model.Cage.AquaticHabitat;
import com.codegym.model.Cage.Aviary;
import com.codegym.model.Cage.Cage;
import com.codegym.model.Cage.TerrestrialHabitat;
import com.codegym.model.Cage.enumerations.CleanlinessEnclosure;
import com.codegym.model.history.HistoryTransaction;
import com.codegym.model.history.HistoryType;
import com.codegym.model.person.visitors.Visitor;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ReadHistoryTransactionSerializer {

    private static ReadHistoryTransactionSerializer readHistoryTransactionSerializer;

    public  static ReadHistoryTransactionSerializer getInstanceReadHistoryTransactionSerializer(){
        if (readHistoryTransactionSerializer == null){
            readHistoryTransactionSerializer = new ReadHistoryTransactionSerializer();
        }
        return readHistoryTransactionSerializer;
    }



    private ReadHistoryTransactionSerializer() {
    }

    public void writeToCSV(List<HistoryTransaction> objects) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("historyTransaction.csv"))) {
            writer.println("Id,Object Id,History Type,Total Money,Date");
            for (HistoryTransaction obj : objects) {
                writer.println(obj.getId() + "," +
                        obj.getObjectId() + "," +
                        obj.getHistoryType()+ "," +
                        obj.getTotalMoney()+ "," +
                        obj.getDate()
                );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<HistoryTransaction> readFromCSV() {
        List<HistoryTransaction> loadedObjects = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("historyTransaction.csv"))) {
            String line;
            Boolean co = false;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length > 0 && co) {

                    String id = data[0];
                    String objectId = data[1];
                    HistoryType historyType = HistoryType.valueOf(data[2]);
                    double totalMoney = Double.parseDouble(data[3]);
                    Date date = Date.valueOf(data[4]);
                    loadedObjects.add(new HistoryTransaction(id,objectId,historyType,totalMoney,date));
                }
                co = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadedObjects;
    }
}
