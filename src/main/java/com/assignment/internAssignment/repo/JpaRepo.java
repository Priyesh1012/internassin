package com.assignment.internAssignment.repo;

import com.assignment.internAssignment.module.personInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepo extends JpaRepository<personInfo,Integer> {

}
