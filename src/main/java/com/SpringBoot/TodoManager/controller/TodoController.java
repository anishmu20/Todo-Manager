package com.SpringBoot.TodoManager.controller;

import com.SpringBoot.TodoManager.model.Todo;
import com.SpringBoot.TodoManager.service.TodoServiceImple;
import com.SpringBoot.TodoManager.service.imple.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {


    Logger logger= LoggerFactory.getLogger(TodoController.class);
    @Autowired
    private TodoService todoService;

    Random random= new Random();

     //create
    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){

        logger.info("Create Todo");
        int id= random.nextInt(99999999);
        Date CurrDate= new Date();
        todo.setAddedDate(CurrDate);
        logger.info("TodoAddedDate{}",CurrDate);
        todo.setId(id);
        logger.info("TodoDate{}",todo.getTododate());
         // call service logic
        return new ResponseEntity<>(todoService.create(todo), HttpStatus.CREATED);
    }
    // getAll
    @GetMapping
    public List<Todo> getAllData(){
        logger.info("Processing request");
        List<Todo> todosAllData=todoService.getAll();
        logger.info("Request process  successfully");

        return  todosAllData;
    }
  // getOne Data
    @GetMapping("/{id}")
    public Todo getData(@PathVariable int id) throws Exception {
        logger.info("Processing data request");
        Todo todosData= todoService.getData(id);
        logger.info("Data requested successfully ");
        return todosData;
    }
    //Update

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo> updateTodoHandler(@RequestBody Todo todoWithNewDetails,@PathVariable int todoId){
        Date CurrDate= new Date();
        todoWithNewDetails.setAddedDate(CurrDate);
        Todo todo1= todoService.updateTodo(todoWithNewDetails,todoId);
         return ResponseEntity.ok(todo1);

    }
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodoHandler(@PathVariable int todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Deleted Successfully");
    }



}
