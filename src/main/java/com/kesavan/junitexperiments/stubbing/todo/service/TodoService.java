package com.kesavan.junitexperiments.stubbing.todo.service;

import java.util.List;

public interface TodoService {

    public List<String> retrieveTodosByCategory(String category);

}
