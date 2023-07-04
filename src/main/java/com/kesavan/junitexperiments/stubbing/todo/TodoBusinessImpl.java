package com.kesavan.junitexperiments.stubbing.todo;

import com.kesavan.junitexperiments.stubbing.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

// This class is a system under test sample and it is dependent on TodoService.
public class TodoBusinessImpl {

    // This class is a dependency that needs to be mocked, as it is written by some other.
    // And it will be available only while deploying and not while testing/building the app.
    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService){
        this.todoService = todoService;
    }
    // This method is expected to be tested.
    // Needs to stub/mock the function of Todoservice.
    public List<String> retreiveRelatedTodos(String topic, String category){
        return todoService.retrieveTodosByCategory(category)
                .stream()
                .filter(todo -> todo.contains(topic))
                .toList();
    }
}
