package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Guest;
import com.MolvenoLakeResort.model.restaurant.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.MolvenoLakeResort.model.restaurant.persistence.TableRepository;


import java.util.Optional;

@RestController
@RequestMapping("api/tables")
public class TableController {

    @Autowired
    private TableRepository tableRepository;

    @PostMapping
    public ResponseEntity<Table> create(@RequestBody Table newTable) {
        Optional<Table> possibleTable = (this.tableRepository.findById(newTable.getId()));

        if (possibleTable.isPresent()) {
                return new ResponseEntity<Table>(HttpStatus.CONFLICT);
            } else {
            return new ResponseEntity<Table>(this.tableRepository.save(newTable), HttpStatus.CREATED);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Table>> list() {
        return new ResponseEntity<Iterable<Table>>(this.tableRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Table> findById(@PathVariable long id) {

        Optional<Table> result = (this.tableRepository.findById(id));

        if (result.isPresent()) {
            return new ResponseEntity<Table>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Table> updateById(@PathVariable long id, @RequestBody Table update) {

        Optional<Table> possibleVictim = (this.tableRepository.findById(id));

        if (possibleVictim.isPresent()) {
            Table victim = possibleVictim.get();

            victim.setCapacity(update.getCapacity());

            return new ResponseEntity<Table>(this.tableRepository.save(victim), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Table> deleteById(@PathVariable long id) {

        Optional<Table> result = (this.tableRepository.findById(id));

        if (result.isPresent()) {
            this.tableRepository.deleteById(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


//    @GetMapping("{capacity}")
//    public ResponseEntity<Table> findByCapacity(@PathVariable int capacity) {
//      Optional <Table> result = this.tableRepository.findByCapacity(capacity);
//
//        if (result.isPresent()) {
//            return new ResponseEntity<Table>(result.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PutMapping("{capacity}")
//    public ResponseEntity<Table> updateByCapacity(@PathVariable int capacity, @RequestBody Table update){
//
//        Optional<Table> possibleVictim = (this.tableRepository.findByCapacity(capacity));
//
//        if (possibleVictim.isPresent()){
//            Table victim = possibleVictim.get();
//
//            victim.setId(update.getId());
//            victim.setCapacity(update.getCapacity());
//
//            victim = this.tableRepository.save(victim);
//
//            return new ResponseEntity<Table>(this.tableRepository.save(victim),HttpStatus.OK);
//
//        }else{
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//}