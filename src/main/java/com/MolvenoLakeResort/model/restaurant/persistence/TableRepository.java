package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TableRepository extends CrudRepository<Table, Long> {

    Optional <Table> findByCapacity(int capacity);

    Optional<Iterable<Table>> findAllByCapacity(int capacity);

    List<Table> findAllByCapacityGreaterThanEqualOrderByCapacityAsc(int capacity);


}