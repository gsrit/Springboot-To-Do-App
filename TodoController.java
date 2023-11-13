package com.yourpackage.controller;

import com.yourpackage.model.TodoItem;
import com.yourpackage.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<TodoItem> todoItems = todoService.getAllTodoItems();
        model.addAttribute("todoItems", todoItems);
        return "index";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("todoItem") TodoItem todoItem) {
        todoService.addTodoItem(todoItem);
        return "redirect:/todo/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        todoService.deleteTodoItem(id);
        return "redirect:/todo/list";
    }
}
