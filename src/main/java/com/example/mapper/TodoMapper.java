package com.example.mapper;

import com.example.model.Todo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TodoMapper {
    //@Select("SELECT * FROM todo")
    List<Todo> getAllTodos();

    //@Select("SELECT * FROM todo WHERE id = #{id}")
    Todo getTodoById(Long id);

    //@Insert("INSERT INTO todo (description, completed) VALUES (#{description}, #{completed})")
    //@Options(useGeneratedKeys = true, keyProperty = "id")
    void insertTodo(Todo todo);

    //@Update("UPDATE todo SET description = #{description}, completed = #{completed} WHERE id = #{id}")
    void updateTodo(Todo todo);

    //@Delete("DELETE FROM todo WHERE id = #{id}")
    void deleteTodo(Long id);
}
