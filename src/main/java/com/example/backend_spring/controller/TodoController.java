package com.example.backend_spring.controller;

import com.example.backend_spring.model.Lists;
import com.example.backend_spring.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/todos") // Optional: base URL for clarity
public class TodoController {

    private final TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getList(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.getList(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllLists() {
        return new ResponseEntity<>(service.getLists(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addList(@RequestBody Lists list) {
        return new ResponseEntity<>(service.addList(list), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateList(@PathVariable("id") int id, @RequestBody Lists list) {
        return new ResponseEntity<>(service.updateList(id, list), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteList(@PathVariable("id") int id) {
        return new ResponseEntity<>(service.deleteList(id), HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/completed")
    public ResponseEntity<?> completed() {
        return new ResponseEntity<>(service.getTodos(), HttpStatus.OK);
    }
}
