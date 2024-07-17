package com.example.repository;

import com.example.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // private static final class TodoMapper implements RowMapper<Todo> {
    //     public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
    //         Todo todo = new Todo();
    //         todo.setId(rs.getLong("id"));
    //         todo.setDescription(rs.getString("description"));
    //         todo.setCompleted(rs.getBoolean("completed"));
    //         return todo;
    //     }
    // }

    // public void save(Todo todo) {
    //     jdbcTemplate.update("INSERT INTO todo (description, completed) VALUES (?, ?)",
    //             todo.getDescription(), todo.isCompleted());
    // }

    // public Todo findById(Long id) {
    //     return jdbcTemplate.queryForObject("SELECT * FROM todo WHERE id = ?", new Object[]{id}, new TodoMapper());
    // }

    // public List<Todo> findAll() {
    //     return jdbcTemplate.query("SELECT * FROM todo", new TodoMapper());
    // }

    // public void update(Todo todo) {
    //     jdbcTemplate.update("UPDATE todo SET description = ?, completed = ? WHERE id = ?",
    //             todo.getDescription(), todo.isCompleted(), todo.getId());
    // }

    // public void delete(Long id) {
    //     jdbcTemplate.update("DELETE FROM todo WHERE id = ?", id);
    // }
}
