package com.example.todolist.controller.todo;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.todolist.common.dto.DataResponseDto;
import com.example.todolist.controller.todo.request.TodoSaveRequest;
import com.example.todolist.controller.todo.request.TodoUpdateRequest;
import com.example.todolist.controller.todo.response.TodoResponse;
import com.example.todolist.service.TodoService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
class TodoListController {

    @Autowired
    TodoService todoService;


    @PostMapping("/todos")
    public Long saveTodo(@RequestBody TodoSaveRequest request) {
        return todoService.saveTodo(request);
    }

    @GetMapping("/todos")
    public DataResponseDto<List<TodoResponse>> todoList() {
        List<TodoResponse> todos = todoService.getAllTodo();
        return DataResponseDto.of(todos);
    }

    @GetMapping("/todos/{todoId}")
    public DataResponseDto<TodoResponse> todoDetail(@PathVariable Long todoId) {
        TodoResponse todo = todoService.getTodo(todoId);
        return DataResponseDto.of(todo);
    }

    @PutMapping("/todos/{todoId}")
    public Long updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequest request) {
        return todoService.updateTodo(todoId, request);
    }


   @DeleteMapping("/todos/{todoId}")
   public Long deleteTodo(@PathVariable Long todoId) {
       Long deletedId = todoService.deleteTodo(todoId);
       return deletedId;
   }


}