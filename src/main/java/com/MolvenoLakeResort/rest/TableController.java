package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Table;
import com.MolvenoLakeResort.model.restaurant.persistence.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("api/tables")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    @PostMapping
    public Table create(@RequestBody Table newTable){
        this.tableRepository.add(newTable);
        return newTable;
    }

    @GetMapping
    public Collection<Table> list(){
        return this.tableRepository.findAll();
    }

    @GetMapping("{id}")
    public Table findById(@PathVariable long id){
        Table result = this.tableRepository.findById(id);
        return result;
    }

    @PutMapping("{id}")
    public Table updateById(@PathVariable long id, @RequestBody Table update){
        return this.tableRepository.update(id, update);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable long id){
        this.tableRepository.removeById(id);
    }

}