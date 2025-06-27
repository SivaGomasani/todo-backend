package com.example.backend_spring.service;

import java.util.List;

import com.example.backend_spring.model.Lists;
import com.example.backend_spring.model.Todos;
import com.example.backend_spring.repository.DeletedRepo;

import org.springframework.stereotype.Service;

@Service
public class DeletedService 
{
	DeletedRepo repo ;
	
	public DeletedService(DeletedRepo repo)
	{
		this.repo = repo;
	}
	
	public List<Todos> getTodos()
	{
		return repo.findAll();
	}
	public String addTodos(Lists list)
	{
		if(list!=null)
		{
			Todos todo=new Todos();
			todo.setDescription(list.getDescription());
			todo.setDuedate(list.getDuedate());
			todo.setPriority(list.getPriority());
			todo.setName(list.getName());
			todo.setId(list.getId());
			repo.save(todo);
			return "Added Successfully";
		}
		return "Duplication occured";
	}
}
