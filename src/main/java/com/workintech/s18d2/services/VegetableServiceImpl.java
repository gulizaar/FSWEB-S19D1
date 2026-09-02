package com.workintech.s18d2.services;

import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public class VegetableServiceImpl implements VegetableService{
    private VegetableRepository vegetableRepository;

    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }


    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }


    @Override
    public Vegetable getById(Long id) {
        if (id < 0) {
            throw new PlantException("Id 0'dan küçük olamaz.");
        }
        return vegetableRepository.findById(id) .orElseThrow(() ->
                new PlantException( "Bu id ile vegetable bulunamadı: " + id ) );
    }



    @Override
    public Vegetable delete( Long id) {
        if (id < 0) { throw new PlantException("Id 0'dan küçük olamaz."); } Vegetable vegetable = vegetableRepository.findById(id) .orElseThrow(() -> new PlantException( "Bu id ile vegetable bulunamadı: " + id ) ); vegetableRepository.delete(vegetable);
        return vegetable;

    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }
}
