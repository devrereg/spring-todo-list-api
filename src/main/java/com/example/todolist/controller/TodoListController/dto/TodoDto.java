package com.example.todolist.controller.TodoListController.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.todolist.domain.TodoEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TodoDto {

    private List<TodoEntity> todoList = new ArrayList<>();   
    
    @Data
    @NoArgsConstructor
    public static class TodoSimple {
        private Long id;
        private String title;
        private String description;
        private Boolean isDel;

        public TodoSimple(TodoEntity todo) {
            this.id = todo.getId();
            this.title = todo.getTitle();
            this.description = todo.getDescription();
            this.isDel = todo.getIsDel();
        }
    }
}


