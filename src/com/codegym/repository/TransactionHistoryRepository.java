package com.codegym.repository;


import com.codegym.model.history.HistoryTransaction;
import com.codegym.model.history.HistoryType;
import com.codegym.serializer.ReadHistoryTransactionSerializer;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class TransactionHistoryRepository {
    private List<HistoryTransaction> historyTransactions;

    ReadHistoryTransactionSerializer readHistoryTransactionSerializer = ReadHistoryTransactionSerializer.getInstanceReadHistoryTransactionSerializer();

    private static TransactionHistoryRepository historyTransactionRepository;

    private static AnimalRepository animalRepository = AnimalRepository.getAnimalRepository();

    private TransactionHistoryRepository() {
        this.historyTransactions = readHistoryTransactionSerializer.readFromCSV();


    }

    public static TransactionHistoryRepository getHistoryTransactionRepository() {
        if (historyTransactionRepository == null) {
            historyTransactionRepository = new TransactionHistoryRepository();
        }
        return historyTransactionRepository;
    }

    public void addHistoryTransaction(HistoryTransaction historyTransaction) {
        historyTransactions.add(historyTransaction);
        updateFileCSV();
    }

    public void removeHistoryTransaction(String historyTransactionId) {
        historyTransactions.removeIf(historyTransaction -> historyTransaction.getId() == historyTransactionId);
        updateFileCSV();

    }

    public HistoryTransaction findById(String historyTransactionId) {
        HistoryTransaction historyTransaction = null;
        Optional<HistoryTransaction> optionalHistoryTransaction = historyTransactions.stream().filter(x -> historyTransactionId.equals(x.getId())).findFirst();
        if (optionalHistoryTransaction.isPresent()) {
            historyTransaction = optionalHistoryTransaction.get();
        }
        return historyTransaction;

    }

    public List<HistoryTransaction> getAllHistoryTransaction() {
        return historyTransactions;
    }

    public void updateHistoryTransaction(HistoryTransaction updatedHistoryTransaction) {
        for (int i = 0; i < historyTransactions.size(); i++) {
            historyTransactions.set(i, updatedHistoryTransaction);
            updateFileCSV();
            return;

        }
    }

    public double getTotalMoneyOwner(){
        AtomicReference<Double> totalMoney = new AtomicReference<>((double) 0);
        historyTransactions.stream().forEach(historyTransaction -> {
            if (historyTransaction.getHistoryType().equals(HistoryType.BUY_TICKET)){
                totalMoney.set(totalMoney.get() + historyTransaction.getTotalMoney());
            }else {
                totalMoney.set(totalMoney.get()- historyTransaction.getTotalMoney());
            }
        });
        return totalMoney.get();
    }

    public void updateFileCSV() {
        readHistoryTransactionSerializer.writeToCSV(historyTransactions);
    }

}
