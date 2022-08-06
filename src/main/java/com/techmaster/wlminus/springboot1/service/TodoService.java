package com.techmaster.wlminus.springboot1.service;

import com.techmaster.wlminus.springboot1.model.Todo;
import com.techmaster.wlminus.springboot1.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodo() {
        return this.todoRepository.findAll();
    }

    public Todo createNewTodo(Todo newTodo) {
        return this.todoRepository.save(newTodo);
    }

    public List<Todo> getTodoListByStatus(Boolean status) {
        return this.todoRepository.getByStatus(status);
    }

    public Todo getTodoById(Integer id) {
        var todo = todoRepository.findById(id);
        return todo.orElse(null);
    }

    public Todo updateTodo(Todo newTodo, Integer id) {
        return this.todoRepository.save(newTodo);
    }

    public void deleteTodo(Integer id) {
        this.todoRepository.deleteById(id);
    }
}
