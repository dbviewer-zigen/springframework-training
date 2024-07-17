package com.example.controller;

import com.example.model.Todo;
import com.example.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public String getAllTodos(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todos";
    }

    @GetMapping("/create")
    public String createTodoForm() {
        return "createTodo";
    }

    @PostMapping("/create")
    public String createTodo(@RequestParam String description, @RequestParam(required = false, defaultValue = "false") boolean completed) {
        Todo todo = new Todo();
        todo.setDescription(description);
        todo.setCompleted(completed);
        todoService.saveTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/{id}")
    public String getTodo(@PathVariable Long id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "todoDetails";
    }

    @GetMapping("/update/{id}")
    public String updateTodoForm(@PathVariable Long id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "updateTodo";
    }

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable Long id, @RequestParam String description, @RequestParam(required = false, defaultValue = "false") boolean completed) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setDescription(description);
        todo.setCompleted(completed);
        todoService.updateTodo(todo);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }
}
