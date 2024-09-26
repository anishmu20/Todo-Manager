package com.SpringBoot.TodoManager.service;

import com.SpringBoot.TodoManager.dao.TodoDao;
import com.SpringBoot.TodoManager.model.Todo;
import com.SpringBoot.TodoManager.service.imple.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoDaoService  implements TodoService {

   @Autowired
   private TodoDao todoDao;


    @Override
    public Todo create(Todo todo) {               // todo -interface --
        return todoDao.saveTodo(todo);
    }

    @Override
    public List<Todo> getAll() {
        return todoDao.getAll();
    }

    @Override
    public Todo getData(int id) {
        return todoDao.getTodo(id);
    }

    @Override
    public Todo updateTodo(Todo todoWithNewDetails, int todoId) {
        return todoDao.updateTodo(todoId, todoWithNewDetails);
    }

    @Override
    public void deleteTodo(int todoId) {
        todoDao.deleteSingle(todoId);


    }
}
