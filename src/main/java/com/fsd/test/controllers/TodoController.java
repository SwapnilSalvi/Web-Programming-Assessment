package com.fsd.test.controllers;

import com.fsd.test.beans.ResponseHandler;
import com.fsd.test.entities.Product;
import com.fsd.test.entities.Todo;
import com.fsd.test.services.ProductService;
import com.fsd.test.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllTodos() {
        return ResponseHandler.generateResponse("All Todo's",
                HttpStatus.OK,
                todoService.getAllTodos()
        );
    }

    @GetMapping("getTodo/{id}")
    public ResponseEntity<Object> getTodo(@PathVariable Long id) {
        return ResponseHandler.generateResponse("Todo Found",
                HttpStatus.OK,
                todoService.getTodo(id)
        );
    }

    @PostMapping("createTodo")
    public ResponseEntity<Object> createTodo(@RequestBody Todo todo) {
        return ResponseHandler.generateResponse("Todo Created Successfully",
                HttpStatus.CREATED,
                todoService.createTodo(todo)
        );
    }

    @DeleteMapping("deleteTodo/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable Long id) {
        return ResponseHandler.generateResponse("Todo Deleted Successfully",
                HttpStatus.OK,
                todoService.deleteTodo(id)
        );
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<Object> deleteAll() {
        todoService.deleteAll();
        return ResponseHandler.generateResponse("All Todo's Deleted Successfully",
                HttpStatus.OK, null
        );
    }

    @PutMapping("updateTodo")
    public ResponseEntity<Object> updateTodo(@RequestBody Todo todo) {
        return ResponseHandler.generateResponse("Todo Updated Successfully",
                HttpStatus.OK,
                todoService.updateTodo(todo)
        );
    }
}
