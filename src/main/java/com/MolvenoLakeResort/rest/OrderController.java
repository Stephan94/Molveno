package com.MolvenoLakeResort.rest;

import com.MolvenoLakeResort.model.restaurant.Order;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("Orders")
public class OrderController {

    private List<Order> orders = new LinkedList<>();

    @GetMapping
    public List<Order> list(){
        return orders;
    }

    @PostMapping
    public Order create(@RequestBody Order newOrder){
        this.orders.add(newOrder);
        return newOrder;
    }
}
