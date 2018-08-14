package com.MolvenoLakeResort.model.restaurant.persistence;

import com.MolvenoLakeResort.model.restaurant.Ingredient;
import com.MolvenoLakeResort.model.restaurant.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.*;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long> {

    Optional <MenuItem> findByName(String name);



}


