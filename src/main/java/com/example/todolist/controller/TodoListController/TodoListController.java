package com.example.todolist.controller.TodoListController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.common.dto.DataResponseDto;
import com.example.todolist.controller.TodoListController.dto.TodoDto;
import com.example.todolist.domain.TodoEntity;
import com.example.todolist.repository.TodoRepository;
import com.example.todolist.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
class TodoListController {

    @Autowired
    TodoService todoService;


    @GetMapping("/todo-list")
    public DataResponseDto<List<TodoDto.TodoSimple>> selectAll() {
        List<TodoDto.TodoSimple> users = todoService.getAllTodo();
        return DataResponseDto.of(users);
    }

}