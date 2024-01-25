package com.chiatu.todoApp.controller;

import com.chiatu.todoApp.model.Todo;
import com.chiatu.todoApp.repository.TodoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public Iterable<Todo> getALlTodos()  {
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id)  {
        return todoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Todo addTodo(@Valid @RequestBody Todo todo)  {
        return todoRepository.save(todo);
    }

    @PostMapping("/{id}/complete")
    public Todo completeTodo(@PathVariable Long id)  {
        Todo newtodo = todoRepository.findById(id).orElse(null);

        if (newtodo != null) {
            newtodo.setCompleted(!newtodo.isCompleted());
            return todoRepository.save(newtodo);
        }

        return null;
    }

}
