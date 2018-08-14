package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Guest;
import com.MolvenoLakeResort.model.restaurant.Ingredient;
import com.MolvenoLakeResort.model.restaurant.persistence.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("api/ingredients")
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @PostMapping
    public ResponseEntity<Ingredient> create(@RequestBody Ingredient newIngredient) {
        Optional<Ingredient> possibleIngredient = this.ingredientRepository.findByName(newIngredient.getName());

        if (possibleIngredient.isPresent()) {
            Ingredient existingIngredient = possibleIngredient.get();
            return new ResponseEntity<Ingredient>(HttpStatus.CONFLICT);

//            if (existingIngredient.getName().equals(newIngredient.getName())) {
//                return new ResponseEntity<Ingredient>(HttpStatus.CONFLICT);
//            } else {
//
//                return new ResponseEntity<Ingredient>(this.ingredientRepository.save(newIngredient), HttpStatus.CREATED);
//
//            }

        } else {

            return new ResponseEntity<Ingredient>(this.ingredientRepository.save(newIngredient), HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Ingredient>> list() {
        return new ResponseEntity<Iterable<Ingredient>>(this.ingredientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Ingredient> findById(@PathVariable long id) {
        Optional<Ingredient> possibleIngredient = this.ingredientRepository.findById(id);

        if (possibleIngredient.isPresent()) {
            return new ResponseEntity<Ingredient>(possibleIngredient.get(), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Ingredient> updateById(@PathVariable long id, @RequestBody Ingredient update) {
        Optional<Ingredient> possibleIngredient = this.ingredientRepository.findById(id);

        if (possibleIngredient.isPresent()) {
            Ingredient ingredient = possibleIngredient.get();
            ingredient.setName(update.getName());
            ingredient.setPrice(update.getPrice());

            return new ResponseEntity<Ingredient>(this.ingredientRepository.save(ingredient), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Ingredient> deleteById(@PathVariable long id) {
        Optional<Ingredient> possibleIngredient = this.ingredientRepository.findById(id);

        if (possibleIngredient.isPresent()) {
            this.ingredientRepository.deleteById(id);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}