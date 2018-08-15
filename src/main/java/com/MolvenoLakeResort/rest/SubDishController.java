package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.SubDish;
import com.MolvenoLakeResort.model.restaurant.persistence.SubDishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/subDishes")
public class SubDishController {

    @Autowired
    private SubDishRepository subDishRespository;

    @PostMapping
    public ResponseEntity<SubDish> create(@RequestBody SubDish newSubDish) {
        Optional<SubDish> possibleSubDish = this.subDishRespository.findByName(newSubDish.getName());

        if (possibleSubDish.isPresent()) {
            SubDish existingSubDish = possibleSubDish.get();
            return new ResponseEntity<SubDish>(HttpStatus.CONFLICT);

        } else {

            return new ResponseEntity<SubDish>(this.subDishRespository.save(newSubDish), HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<SubDish>> list() {
        return new ResponseEntity<Iterable<SubDish>>(this.subDishRespository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<SubDish> findById(@PathVariable long id) {
        Optional<SubDish> possibleSubDish = this.subDishRespository.findById(id);

        if (possibleSubDish.isPresent()) {
            return new ResponseEntity<SubDish>(possibleSubDish.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<SubDish> updateById(@PathVariable long id, @RequestBody SubDish update) {
        Optional<SubDish> possibleSubDish = this.subDishRespository.findById(id);

        if (possibleSubDish.isPresent()) {
            SubDish subDish = possibleSubDish.get();
            subDish.setName(update.getName());
            subDish.setIngredientListForSubDish(update.getIngredientListForSubDish());

            return new ResponseEntity<SubDish>(this.subDishRespository.save(subDish), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<SubDish> deleteById(@PathVariable long id) {
        Optional<SubDish> possibleSubDish = this.subDishRespository.findById(id);

        if (possibleSubDish.isPresent()) {
            this.subDishRespository.deleteById(id);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
