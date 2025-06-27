package com.example.backend_spring.repository;

import com.example.backend_spring.model.Lists;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<Lists,Integer>
{

}
