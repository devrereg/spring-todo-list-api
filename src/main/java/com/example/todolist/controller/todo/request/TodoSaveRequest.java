package com.example.todolist.controller.todo.request;

import com.example.todolist.domain.TodoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoSaveRequest {
    private String title;
    private String description;
    private Boolean isComplete = false;
    private Boolean isDel = false;

    @Builder
    public TodoSaveRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public TodoEntity toEntity() {
        return TodoEntity.builder().title(title).description(description).isComplete(isComplete).isDel(isDel).build();
    }
}
