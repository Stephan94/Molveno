//package com.MolvenoLakeResort.service;
//
//import com.MolvenoLakeResort.model.restaurant.Table;
//import com.MolvenoLakeResort.model.restaurant.persistence.TableRepository;
//import javafx.scene.control.Tab;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import javax.annotation.PostConstruct;
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@Service
//public class TableService {
//
//        @Autowired
//        private TableRepository tableRepository;
//
//
//        @Transactional
//        public Table save(Table t) {
//
//            this.tableRepository.save(t);
//
//            return t;
//        }
//
//        public Iterable<Table> findAll() {
//
//            return this.tableRepository.findAll();
//        }
//
//        public Optional<Table> findById(long id) {
//
//            return (this.tableRepository.findById(id));
//        }
//
//        public Optional<Table> findByCapacity(int capacity) {
//            return (this.tableRepository.findByCapacity(capacity));
//        }
//
//        @Transactional
//        public void deleteById(long id) {
//            this.tableRepository.deleteById(id);
//        }
//    }
