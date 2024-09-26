package com.SpringBoot.TodoManager.dao;

import com.SpringBoot.TodoManager.helper.helper;
import com.SpringBoot.TodoManager.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Repository
public class TodoDao {

    JdbcTemplate jdbcTemplate;
    Logger logger= LoggerFactory.getLogger(TodoDao.class);

    public TodoDao( @Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        String tableQUERY="create table IF NOT EXISTS  todos (id int primary key,title varchar(400) not null,content varchar(400) not null ,status varchar(10) not null,addedDate datetime,todoDate datetime )";
        int update = jdbcTemplate.update(tableQUERY);
        logger.info("JDBC TABLE CREATED : {} ",update );

    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // save Todo in database
    public Todo saveTodo(Todo todo){
        String insertQuery="insert into todos (id,title,content,status,addedDate,todoDate) values (?,?,?,?,?,?)";
       int update= jdbcTemplate.update(insertQuery,todo.getId(),todo.getTitle(),todo.getContent(),todo.getStatus(),todo.getAddedDate(),todo.getTododate());
       logger.info("AFFECTED ROWS: {} ",update);
        return todo;
    }
    // get single todo from database
    public Todo getTodo(int id){

        String getQuery="select * from todos where id=?";
        Todo todo =  jdbcTemplate.queryForObject(getQuery, new TodoRowMapper(), id);
        return todo;
    }
    // GetAll todo from  database
    public List<Todo> getAll(){
        
        String getQuery="select * from todos";
        List<Todo> query = jdbcTemplate.query(getQuery, new TodoRowMapper());
        return query;
        
//        }).toList();

        //        Todo todo= new Todo();
//        todo.setId((Integer) todoMap.get("id"));
//        todo.setTitle((String) todoMap.get("title"));
//        todo.setContent((String) todoMap.get("content"));
//        todo.setStatus((String) todoMap.get("status"));
//        todo.setAddedDate(helper.parse((LocalDateTime) todoMap.get("addedDate")));
//        todo.setTododate(helper.parse((LocalDateTime) todoMap.get("todoDate")));


    }
    //update todo
    public Todo updateTodo(int id,Todo newTodo){
        String updateQUERY=" update todos set title=?,content=?,status=?,addedDate=?,todoDate=? where id=?";
        int update = jdbcTemplate.update(updateQUERY, newTodo.getTitle(), newTodo.getContent(), newTodo.getStatus(), newTodo.getAddedDate(), newTodo.getTododate(), id);
        newTodo.setId(id);
        return newTodo;
    }

    //Delete todo
    public void deleteSingle(int id){
        String query="delete from todos where id=?";
        int update = jdbcTemplate.update(query, id);
        logger.info("Deleted Rows : {} ",update);

    }
    public void deleteMultiple(int [] ids){
        String query="delete from todos where id=?";
        int[] ints = jdbcTemplate.batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setInt(1, ids[i]);
            }
            @Override
            public int getBatchSize() {
                return ids.length;
            }
        });
        for (int id :ints){
            logger.info("Deleted row : {} ",id);
        }

    }
}
