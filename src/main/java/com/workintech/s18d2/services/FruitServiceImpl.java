package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;

import java.util.List;

public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit getById(Long id) {

        if (id < 0) {
            throw new PlantException("Id 0'dan küçük olamaz.");
        }

        return fruitRepository.findById(id)
                .orElseThrow(() ->
                        new PlantException(
                                "Bu id ile fruit bulunamadı: " + id
                        )
                );
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public Fruit delete(Long id) {

        if (id < 0) {
            throw new PlantException("Id 0'dan küçük olamaz.");
        }

        Fruit fruit = fruitRepository.findById(id)
                .orElseThrow(() ->
                        new PlantException(
                                "Bu id ile fruit bulunamadı: " + id
                        )
                );

        fruitRepository.delete(fruit);

        return fruit;
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }
}