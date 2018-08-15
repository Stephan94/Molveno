package com.MolvenoLakeResort.model.restaurant.persistence;


import com.MolvenoLakeResort.model.restaurant.SubDish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SubDishRepository extends CrudRepository<SubDish, Long> {

    Optional<SubDish> findByName(String name);

}
