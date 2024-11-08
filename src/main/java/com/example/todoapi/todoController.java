package com.example.todoapi;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RequestMapping("/api/v1/todo")
@RestController
public class todoController {

    public todoServiceInterface todoService1;
    public todoServiceInterface todoService2;
    public List<todos>todoList=new ArrayList<todos>();

    public todoController( @Qualifier("/firstService") todoServiceInterface todoService1,
                           @Qualifier("/secondService") todoServiceInterface todoService2 ) {
        this.todoService1=todoService1;
        this.todoService2=todoService2;
        todoList.add(new todos(1,1,"Homework",true));
    }

    @GetMapping
    public List<todos>getAllTodoList(@RequestParam(required = false) String isCompleted){
        System.out.println(isCompleted);
        System.out.println(this.todoService1.getAllData());
        System.out.println(this.todoService2.getAllData());
        return todoList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<todos> getTodo(@PathVariable int id){
        for(todos todo:todoList){
            if(todo.getId()==id){
                return ResponseEntity.status(HttpStatus.OK).body(todo)  ;
            }
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<todos> addTodo(@RequestBody todos todo){
        todoList.add(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo) ;
    }

    @PatchMapping("/{id}")
    public ResponseEntity<todos> updateTodo(@PathVariable int id,@RequestBody todos todot)
    {
        for(todos todo:todoList){
            if(todo.getId()==id){
                todo.setTitle(todot.getTitle());
                return ResponseEntity.status(HttpStatus.OK).body(todo)  ;
            }
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable int id){
        for(todos todo:todoList){
            if(todo.getId()==id){
                todoList.remove(todo);

            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("File not found") ;
    }
}
