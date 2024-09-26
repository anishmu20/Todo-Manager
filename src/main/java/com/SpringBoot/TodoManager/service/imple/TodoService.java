package com.SpringBoot.TodoManager.service.imple;

import com.SpringBoot.TodoManager.model.Todo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
public interface TodoService {


    Todo create(Todo todo);
     List<Todo> getAll();
    Todo getData(int id);
    Todo updateTodo(Todo todoWithNewDetails, int todoId);
    void deleteTodo(int todoId);
}
