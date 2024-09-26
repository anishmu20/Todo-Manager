package com.SpringBoot.TodoManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;
@Entity
@Table(name = "jpa_todos")
public class Todo {
     @Id
    private int Id;
     @Column(name = "todo_title",length = 100)
    private String title;
     @Column(name = "todo_content",length = 300)
    private String content;
     @Column(name = "todo_status",length = 10)
    private String status;
     @Column(name = "todo_addedDate")
    private Date addedDate;
     @Column(name="todo_todoDate")
     @JsonFormat(pattern = "dd/MM/yyyy")
    private Date tododate;


    public Todo(int id, String title, String content, String status,Date addedDate,Date tododate) {
        Id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.addedDate=addedDate;
        this.tododate=tododate;
    }
    public Todo(){

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getTododate() {
        return tododate;
    }

    public void setTododate(Date tododate) {
        this.tododate = tododate;
    }


    @Override
    public String toString() {
        return "Todo{" +
                "Id=" + Id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", addedDate=" + addedDate +
                ", tododate=" + tododate +
                '}';
    }
}
