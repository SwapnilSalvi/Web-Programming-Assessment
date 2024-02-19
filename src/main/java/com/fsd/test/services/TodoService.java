package com.fsd.test.services;

import com.fsd.test.entities.Product;
import com.fsd.test.entities.Todo;
import com.fsd.test.exceptions.EntityAlredyExistException;
import com.fsd.test.exceptions.EntityNotFoundException;
import com.fsd.test.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Todo not found with given id."));
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Todo todo) {
        Optional<Todo> optionalTodo = todoRepository.findById(todo.getId());
        if (optionalTodo.isPresent()) {
            Todo todoToUpdate = optionalTodo.get();
            todoToUpdate.setTitle(todo.getTitle());
            todoToUpdate.setDescription(todo.getDescription());
            todoToUpdate.setStatus(todo.getStatus());
            return todoRepository.save(todoToUpdate);
        }
        throw new EntityNotFoundException("Todo not found with given id.");
    }

    public Todo deleteTodo(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todoToDelete = optionalTodo.get();
            todoRepository.delete(todoToDelete);
            return todoToDelete;
        }
        throw new EntityNotFoundException("Todo not found with given id.");
    }

    public void deleteAll() { todoRepository.deleteAll(); }
}
