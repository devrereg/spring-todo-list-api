package com.example.todolist.service;

import java.util.List;

import com.example.todolist.controller.todo.request.TodoSaveRequest;
import com.example.todolist.controller.todo.request.TodoUpdateRequest;
import com.example.todolist.controller.todo.response.TodoResponse;
import com.example.todolist.domain.TodoEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.todolist.repository.TodoRepository;

@RequiredArgsConstructor    //final or NonNull 옵션 필드를 전부 포함한 생성자 만들어줌
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public Long saveTodo(TodoSaveRequest input) {
        return  todoRepository.save(input.toEntity()).getId();
    }


    @Transactional
    public Long updateTodo(Long id, TodoUpdateRequest input) {
        TodoEntity todo = todoRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        todo.update(input.getTitle(), input.getDescription(), input.getIsComplete() ,input.getIsDel());

        return id;
    }

    public TodoResponse findById(Long id) {
        TodoEntity entity = todoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new TodoResponse(entity);
    }

    public List<TodoResponse> getAllTodo() {
        return todoRepository.findAll().stream().map(TodoResponse::new).toList();
    }

    public TodoResponse getTodo(Long id) {
        TodoEntity todo = todoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new TodoResponse(todo);
    }

    @Transactional
    public Long deleteTodo(Long id) {
        TodoEntity todo = todoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        todo.setIsDel(true);
        todoRepository.save(todo);
        return todo.getId();
    }
}
