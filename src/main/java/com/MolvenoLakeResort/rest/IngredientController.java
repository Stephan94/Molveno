package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Ingredient;
import com.MolvenoLakeResort.model.restaurant.persistence.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController
@RequestMapping("api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping
    public Ingredient create(@RequestBody Ingredient newIngredient){
        this.ingredientRepository.add(newIngredient);
        return newIngredient;
    }

    @GetMapping
    public Collection<Ingredient> list(){
        return this.ingredientRepository.findAll();
    }

    @GetMapping("{id}")
    public Ingredient findById(@PathVariable long id){
        return  this.ingredientRepository.findById(id);
    }

    @PutMapping("{id}")
    public Ingredient updateById(@PathVariable long id, @RequestBody Ingredient update){
        return this.ingredientRepository.update(id, update);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        this.ingredientRepository.removeById(id);
    }

}