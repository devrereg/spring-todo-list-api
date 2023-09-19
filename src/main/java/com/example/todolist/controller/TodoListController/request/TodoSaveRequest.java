package com.example.todolist.controller.TodoListController.request;


import com.example.todolist.domain.TodoEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaveTodoRequest {
    private String title;
    private String description;
}
