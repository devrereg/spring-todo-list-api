package com.example.todolist.controller.TodoListController.response;

import com.example.todolist.domain.TodoEntity;
import lombok.Getter;

@Getter
public class TodoResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final Boolean isDel;

    public TodoResponse(TodoEntity todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.isDel = todo.getIsDel();
    }
}
