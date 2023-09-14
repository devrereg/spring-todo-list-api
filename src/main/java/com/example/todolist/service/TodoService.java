package com.example.todolist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.controller.TodoListController.dto.TodoDto;
import com.example.todolist.repository.TodoRepository;

@Service
public class TodoService {

  @Autowired
    private  TodoRepository todoRepository;


    public List<TodoDto.TodoSimple> getAllTodo() {
    return todoRepository.findAll()
            .stream().map(TodoDto.TodoSimple::new).collect(Collectors.toList());
}
    
}
