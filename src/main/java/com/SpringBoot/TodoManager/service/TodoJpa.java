package com.SpringBoot.TodoManager.service;

import com.SpringBoot.TodoManager.model.Todo;
import com.SpringBoot.TodoManager.reposities.TodoRepo;
import com.SpringBoot.TodoManager.service.imple.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Primary
public class TodoJpa implements TodoService {

    @Autowired
    TodoRepo todoRepo;


    @Override
    public Todo create(Todo todo) {

        return todoRepo.save(todo);

    }

    @Override
    public List<Todo> getAll() {
        return todoRepo.findAll();
    }

    @Override
    public Todo getData(int id) {
        return todoRepo.findById(id).orElseThrow(() -> new RuntimeException("Todo Id GIVEN IS NOT PRESENT"));
    }

    @Override
    public Todo updateTodo(Todo todoWithNewDetails, int todoId) {

        Todo oldTodo = todoRepo.findById(todoId).orElseThrow(()-> new RuntimeException("Todo with this id is not found"));
        oldTodo.setContent(todoWithNewDetails.getContent());
        oldTodo.setTitle(todoWithNewDetails.getTitle());
        oldTodo.setAddedDate(todoWithNewDetails.getAddedDate());
        oldTodo.setTododate(todoWithNewDetails.getTododate());
        oldTodo.setStatus(todoWithNewDetails.getStatus());
        Todo updatedTodo = todoRepo.save(oldTodo);

        return updatedTodo;
    }

    @Override
    public void deleteTodo(int todoId) {
        todoRepo.deleteById(todoId);

    }
}
