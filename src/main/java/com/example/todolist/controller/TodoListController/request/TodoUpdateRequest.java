package com.example.todolist.controller.TodoListController.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoUpdateRequest {
    public String title;
    private String description;
    private Boolean isDel;

    @Builder
    public TodoUpdateRequest(String title, String description, Boolean isDel) {
        this.title = title;
        this.description = description;
        this.isDel = isDel;
    }
}
