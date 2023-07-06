package com.kesavan.junitexperiments.mocking.todo;

import com.kesavan.junitexperiments.stubbing.todo.TodoBusinessImpl;
import com.kesavan.junitexperiments.stubbing.todo.service.TodoService;
import com.kesavan.junitexperiments.stubbing.todo.service.TodoServiceStub;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

    @Test
    void testTodoServiceWithMock(){

        // Setup the mock dependent
        TodoService mockObject = mock(TodoService.class);

        // Stubbing the functionality of mock
        when(mockObject.retrieveTodosByCategory(anyString())).thenReturn(Arrays.asList(
                "Wake Up",
                "Brush",
                "Learn Junit",
                "Practice Junit",
                "Sleep"));

        // Note that we are instatiating the SUT with a mocked dependent.
        TodoBusinessImpl todoBusinessSUT = new TodoBusinessImpl(mockObject);

        List<String> resultantTodos = todoBusinessSUT.retreiveRelatedTodos("Junit", "Dummy Category");
        assertFalse(resultantTodos.isEmpty());
        assertEquals(2, resultantTodos.size());
    }

}
