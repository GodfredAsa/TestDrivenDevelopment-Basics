package com.in28minutes.business;

import com.in28minutes.dataApi.TodoService;

import java.util.ArrayList;
import java.util.List;

// TodoService is a dependency usually dependencies are stubbed.
// TodoBusinessImp is the SUT [ System Under Test ]

public class TodoBusinessImp {

    private TodoService service;

    public TodoBusinessImp(TodoService service) {
        this.service = service;
    }

    public List<String> retrieveRelatedTodos(String user){
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = service.retrieveTodos(user);

        for(String todo: todos){
            if(todo.contains("Spring"))  filteredTodos.add(todo);
        }
        return filteredTodos;
    }
}
