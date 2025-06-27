package com.example.backend_spring.service;

import java.util.List;
import java.util.Optional;

import com.example.backend_spring.model.Lists;
import com.example.backend_spring.model.Todos;
import com.example.backend_spring.repository.TodoRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService 
{
	TodoRepo repo;
	@Autowired
	DeletedService service;
	
	@Autowired
	public TodoService(TodoRepo repo)
	{
		this.repo = repo;
	}
	
	public List<Lists> getLists()
	{
		return repo.findAll();
	}
	
	public Optional<Lists> getList(int id)
	{
		Optional<Lists> list = repo.findById(id);
		if(list!=null)
			return list;
		
		return Optional.empty();
	}
	
	public String deleteList(int id)
	{
		Lists list = repo.getById(id);
		if(list!=null)
		{
			service.addTodos(list);
			repo.delete(list);
			return "Deleted Successfully";
		}
			
		
		return "List is not Deleted";
	}
	
	public String addList(Lists list)
	{
		Lists l = repo.save(list);
		if(l!=null)
			return "Added Successfullly";
		return "List is not Added";
	}
	
	public String updateList(int id,Lists list)
	{
		Lists l = repo.getById(id);
		if(l!=null) {
			l.setDescription(list.getDescription());
			l.setDuedate(list.getName());
			l.setName(list.getName());
			l.setPriority(list.getPriority());
			repo.save(l);
			return "Updated Successfullly";
		}
		return "List is not There!";
	}
	
	public List<Todos> getTodos()
	{
		return service.getTodos();
	}
	
	
	
	
	
}
