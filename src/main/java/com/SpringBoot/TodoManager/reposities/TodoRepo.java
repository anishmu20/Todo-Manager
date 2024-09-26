package com.SpringBoot.TodoManager.reposities;

import com.SpringBoot.TodoManager.model.Todo;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepo extends JpaRepository<Todo,Integer> {

}
