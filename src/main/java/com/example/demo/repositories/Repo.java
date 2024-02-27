package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Employee;


public interface Repo extends JpaRepository<Employee, Long>{

}