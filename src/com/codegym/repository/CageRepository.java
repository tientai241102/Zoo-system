package com.codegym.repository;

import com.codegym.model.Cage.Cage;

import java.util.ArrayList;
import java.util.List;

public class CageRepository {
    private List<Cage> cages;

    public CageRepository() {
        this.cages = new ArrayList<>();
    }

    public void addCage(Cage cage) {
        cages.add(cage);
    }

    public void removeCage(String cageId) {
        cages.removeIf(cage -> cage.getCageId().equals(cageId));

    }

    public Cage findById(String cageId) {
        for (Cage cage : cages) {
            if (cageId == cage.getCageId()) {
                return cage;
            }
        }
        return null;
    }

    public List<Cage> getAllCages() {
        return cages;
    }

    public void updateCage(Cage updatedCage) {
        for (int i = 0; i < cages.size(); i++) {
                cages.set(i, updatedCage);
                return;

        }
    }
}
