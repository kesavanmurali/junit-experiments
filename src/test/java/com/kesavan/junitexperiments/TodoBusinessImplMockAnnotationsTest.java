package com.kesavan.junitexperiments;

import com.kesavan.junitexperiments.stubbing.todo.TodoBusinessImpl;
import com.kesavan.junitexperiments.stubbing.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoBusinessImplMockAnnotationsTest {

    @Mock
    private TodoService todoServiceMock;

    @InjectMocks
    private TodoBusinessImpl todoBusinessSUT;

    @Test
    void testTodoServiceWithMockAnnotations(){

        // Stubbing the functionality of mock
        when(todoServiceMock.retrieveTodosByCategory(anyString())).thenReturn(Arrays.asList(
                "Wake Up",
                "Brush",
                "Learn Junit",
                "Practice Junit",
                "Sleep"));

        List<String> resultantTodos = todoBusinessSUT.retreiveRelatedTodos("Junit", "Dummy Category");
        assertFalse(resultantTodos.isEmpty());
        assertEquals(2, resultantTodos.size());
    }

}
