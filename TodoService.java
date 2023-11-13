package com.yourpackage.service;

import com.yourpackage.model.TodoItem;
import com.yourpackage.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoItem> getAllTodoItems() {
        return todoRepository.findAll();
    }

    public void addTodoItem(TodoItem todoItem) {
        todoRepository.save(todoItem);
    }

    public void deleteTodoItem(Long id) {
        todoRepository.deleteById(id);
    }
}
