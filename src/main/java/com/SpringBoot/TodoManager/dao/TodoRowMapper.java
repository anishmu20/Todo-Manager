package com.SpringBoot.TodoManager.dao;

import com.SpringBoot.TodoManager.helper.helper;
import com.SpringBoot.TodoManager.model.Todo;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TodoRowMapper implements RowMapper<Todo> {

    @Override
    public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {

        Todo todo= new Todo();
        todo.setId( rs.getInt("id"));
        todo.setTitle( rs.getString("title"));
        todo.setContent( rs.getString("content"));
        todo.setStatus( rs.getString("status"));
        todo.setAddedDate(helper.parse((LocalDateTime) rs.getObject("addedDate")));
        todo.setTododate(helper.parse((LocalDateTime) rs.getObject("todoDate")));


        return todo;
    }
}
