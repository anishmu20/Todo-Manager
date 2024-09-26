package com.SpringBoot.TodoManager;

import com.SpringBoot.TodoManager.dao.TodoDao;
import com.SpringBoot.TodoManager.model.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class TodoManagerApplication implements CommandLineRunner {
	@Autowired
	private TodoDao todoDao;
	Logger logger= LoggerFactory.getLogger(TodoManagerApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(TodoManagerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

//		Todo todo= new Todo();
//        todo.setId(123);
//		todo.setTitle("python Course");
//		todo.setContent("python django COURSE");
//		todo.setStatus("pending");
//		todo.setAddedDate(new Date());
//		todo.setTododate(new Date());

//		List<Todo> all = todoDao.getAll();
//		logger.info("Todo {} ",all);


	}
}
