package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/workingtech/fruits")
public class FruitController {

    private FruitService fruitService;

    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping()
    public List<Fruit> findAll(){
        return fruitService.getByPriceAsc();
    }
    @GetMapping("/{id}")
    public Fruit findById(@PathVariable Long id){

        return fruitService.getById(id);

    }
    @GetMapping("/desc")
    public List<Fruit> findAllByPriceDesc(){
        return fruitService.getByPriceDesc();
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Fruit save(@RequestBody Fruit fruit){
        return fruitService.save(fruit);

    }
    @PostMapping("/{name}")
    public List<Fruit> findByName(@PathVariable  String name){
        return fruitService.searchByName(name);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){

        fruitService.delete(id);
    }
}
