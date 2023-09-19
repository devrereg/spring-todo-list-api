package com.example.todolist.controller.TodoListController.request;


import com.example.todolist.domain.TodoEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoSaveRequest {
    private String title;
    private String description;
    private final Boolean isDel = false;

    @Builder
    public TodoSaveRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public TodoEntity toEntity() {
        return TodoEntity.builder().title(title).description(description).isDel(isDel).build();
    }
}
