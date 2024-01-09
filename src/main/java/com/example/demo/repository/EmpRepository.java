package com.example.demo.repository;

//import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee_Entity;

@Repository
public interface EmpRepository extends JpaRepositoryImplementation<Employee_Entity, Integer> {

}
