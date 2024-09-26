package com.SpringBoot.TodoManager.service;

import com.SpringBoot.TodoManager.exception.ResourceNotFoundException;
import com.SpringBoot.TodoManager.model.Todo;
import com.SpringBoot.TodoManager.service.imple.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImple  implements TodoService {
    List<Todo> todos= new ArrayList<>();
    Logger logger= LoggerFactory.getLogger(TodoServiceImple.class);
    //create Todo method
    public Todo create(Todo todo){
        todos.add(todo);
        logger.info("Todo {}",this.todos);
        return  todo;
    }

    public List<Todo> getAll(){

        logger.info("Todos {} ",todos);
        return todos;
    }
    
    public  Todo getData(int id) throws ResourceNotFoundException {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
       throw  new ResourceNotFoundException("Todos id is not found", HttpStatus.NOT_FOUND);

    }

    public Todo updateTodo(Todo todoWithNewDetails, int todoId) {

        List<Todo> newUpdatedList=todos.stream().map(t->{
            if (t.getId()==todoId){
                //perform
                t.setContent(todoWithNewDetails.getContent());
                t.setTitle(todoWithNewDetails.getTitle());
                t.setStatus(todoWithNewDetails.getStatus());

                return t;
            }
            else{
                return t;
            }

        }).toList();
        todos=newUpdatedList;
        todoWithNewDetails.setId(todoId);
        return todoWithNewDetails;
    }

    public void deleteTodo(int todoId) {
        logger.info("Deleting");

        todos= todos.stream().filter(t->t.getId()!=todoId).toList();
        logger.info("Deleted");

    }
}
