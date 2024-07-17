package com.example.service;

import com.example.mapper.TodoMapper;
import com.example.model.Todo;
import com.example.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    //@Autowired
    //private TodoRepository todoRepository;

    @Autowired
    private TodoMapper todoMapper;


    public void saveTodo(Todo todo) {
        // todoRepository.save(todo);
        todoMapper.insertTodo(todo);
    }

    public Todo getTodoById(Long id) {
        // return todoRepository.findById(id);
        return todoMapper.getTodoById(id);
    }

    public List<Todo> getAllTodos() {
        // return todoRepository.findAll();
        return todoMapper.getAllTodos();
    }

    public void updateTodo(Todo todo) {
        // todoRepository.update(todo);
        todoMapper.updateTodo(todo);
    }

    public void deleteTodo(Long id) {
        // todoRepository.delete(id);
        todoMapper.deleteTodo(id);
    }
}
