package com.example.demo.service;

import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee_Entity;
import com.example.demo.repository.EmpRepository;
//import com.example.demo.repository.JpaRepository;

@Service
public class Employee_Service {
	
	@Autowired
	private EmpRepository repo;
    public void addEmp(Employee_Entity e) {
	  repo.save(e);
    }
   public List<Employee_Entity> getAllEmp(){
	   return repo.findAll();
   }
   public Employee_Entity getEmpById(int id) {
	  Optional<Employee_Entity> e=repo.findById(id);
	  if(e.isPresent()) {
		  return e.get();
	  }
	  return null;
   }
   public void deleteEmp(int id) {
	   repo.deleteById(null);
   }
}
