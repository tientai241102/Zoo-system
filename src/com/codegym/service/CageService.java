package com.codegym.service;

import com.codegym.model.Cage.Cage;
import com.codegym.repository.CageRepository;

import java.util.List;

public class CageService {

    private CageRepository cageRepository = new CageRepository();


    public List<Cage> getCages(){
        return cageRepository.getAllCages();
    }

    public Cage findById(String cageId){
        return cageRepository.findById(cageId);
    }
    public void addCage(Cage cage) {
        cageRepository.addCage(cage);
    }
    public void updateCage(Cage cage) {
        cageRepository.updateCage(cage);
    }

    public void removeCage(String cageId) {
        cageRepository.removeCage(cageId);
    }
}
