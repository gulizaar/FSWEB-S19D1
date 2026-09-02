package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech/vegetables")
public class VegetableController {

    private VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping()
    public List<Vegetable> findAll(){
        return vegetableService.getByPriceAsc();

    }
    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable Long id){
        return vegetableService.getById(id);
    }
    @GetMapping("/desc")
    public List<Vegetable> findAllByPriceDesc(){
        return vegetableService.getByPriceDesc();

    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetable save(@RequestBody  Vegetable vegetable){
        return vegetableService.save(vegetable);
    }
    @PostMapping("/{name}")
    public List<Vegetable> findByName(@PathVariable String name){
        return vegetableService.searchByName(name);

    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        vegetableService.delete(id);
    }


}
