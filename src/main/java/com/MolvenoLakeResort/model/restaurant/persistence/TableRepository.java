package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableRepository extends CrudRepository<Table, Long> {

    Table findByCapacity(int capacity);

    Iterable<Table> findAllByCapacity(int capacity);
}