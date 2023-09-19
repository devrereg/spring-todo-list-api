package com.example.todolist.controller.todo.response;

import com.example.todolist.domain.TodoEntity;
import lombok.Getter;

@Getter
public class TodoResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final Boolean isComplete;
    private final Boolean isDel;

    public TodoResponse(TodoEntity todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.description = todo.getDescription();
        this.isComplete = todo.getIsComplete();
        this.isDel = todo.getIsDel();
    }
}
