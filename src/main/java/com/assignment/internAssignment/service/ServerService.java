package com.assignment.internAssignment.service;

import com.assignment.internAssignment.module.personInfo;
import com.assignment.internAssignment.repo.JpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

    @Autowired
    JpaRepo repo;

    public List<personInfo> getAllInfo(){
        return repo.findAll();
    }

    public personInfo addInfo(personInfo  info) {
        return repo.save(info);
    }

    public personInfo updateProduct(int id, personInfo info) {
        return repo.save(info);
    }

    public Optional<personInfo> getInfoById(int id) {
        return repo.findById(id);
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
