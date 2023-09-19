package com.example.todolist.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    catalog = "todo-list-demo",    
    name = "todo")
@NoArgsConstructor
@Getter
@Setter
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "is_del")
    private Boolean isDel = false;

    @Builder
    public TodoEntity(String title, String description, Boolean isDel) {
        this.title = title;
        this.description = description;
        this.isDel = isDel;
    }

    public void update(String title, String description, Boolean isDel) {
        this.title = title;
        this.description = description;
        this.isDel = isDel;
    }
}