package com.example.backend_spring.repository;

import com.example.backend_spring.model.Todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeletedRepo extends JpaRepository<Todos,Integer>
{

}
