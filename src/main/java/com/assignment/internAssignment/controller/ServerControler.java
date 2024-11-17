package com.assignment.internAssignment.controller;

import com.assignment.internAssignment.module.personInfo;
import com.assignment.internAssignment.service.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ServerControler {

    @Autowired
    private ServerService service;


    @GetMapping("/home")
    public ResponseEntity<List<personInfo>> getAllInfo(){
        List<personInfo> persons= service.getAllInfo();
        if (persons != null) {
            return new ResponseEntity<>(persons, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addinfo")
    public ResponseEntity<?> addProduct(@RequestBody personInfo info) {
        try {
            personInfo person1 = service.addInfo(info);
            return new ResponseEntity<>(person1, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);


        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody personInfo info) {

        personInfo person1 = null;
        person1 = service.updateProduct(id,info);

        if (person1 != null) {
            return new ResponseEntity<>("updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delinfo/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Optional<personInfo> product = service.getInfoById(id);
        if (product.isPresent()) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

    }
}
