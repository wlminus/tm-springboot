package com.techmaster.wlminus.springboot1.controller;

import com.techmaster.wlminus.springboot1.model.Todo;
import com.techmaster.wlminus.springboot1.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodosController {
    private TodoService todoService;

    public TodosController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Todo>> getTodoListByStatus(@RequestParam(value = "status", required = false) Boolean status) {
        var result = this.todoService.getTodoListByStatus(status);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getTodoListById(@PathVariable("todoId") Integer id) {
        var result = this.todoService.getTodoById(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping("")
    public ResponseEntity<Todo> createNewTodo(@RequestBody Todo newTodo) {
        var ret = this.todoService.createNewTodo(newTodo);
        return ResponseEntity.created(URI.create("/")).body(ret);
    }

    @PatchMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoById(
            @RequestBody Todo newTodo,
            @PathVariable("todoId") Integer id
    ) {
        var ret = this.todoService.updateTodo(newTodo, id);
        return ResponseEntity.ok().body(ret);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable("todoId") Integer id) {
        this.todoService.deleteTodo(id);
        return ResponseEntity.ok().body(null);

    }
}
