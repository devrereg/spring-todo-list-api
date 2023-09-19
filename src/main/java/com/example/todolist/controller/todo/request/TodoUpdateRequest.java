package com.example.todolist.controller.todo.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoUpdateRequest {
    public String title;
    private String description;
    private Boolean isComplete;
    private Boolean isDel;

    @Builder
    public TodoUpdateRequest(String title, String description, Boolean isComplete, Boolean isDel) {
        this.title = title;
        this.description = description;
        this.isComplete = isComplete;
        this.isDel = isDel;
    }
}
