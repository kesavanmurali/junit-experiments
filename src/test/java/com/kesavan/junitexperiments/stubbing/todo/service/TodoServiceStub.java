package com.kesavan.junitexperiments.stubbing.todo.service;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

    public List<String> retrieveTodosByCategory(String category){
        return Arrays.asList(
                "Wake Up",
                "Brush",
                "Learn Junit",
                "Practice Junit",
                "Sleep");
    }

}
