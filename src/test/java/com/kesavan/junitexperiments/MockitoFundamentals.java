package com.kesavan.junitexperiments;

import com.kesavan.junitexperiments.stubbing.todo.TodoBusinessImpl;
import com.kesavan.junitexperiments.stubbing.todo.service.TodoService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class MockitoFundamentals {

    @Test
    void testDefaultValuesNiceMocks() {

        List<String> mockList = mock(List.class);

        assertNull(mockList.get(0));
        assertEquals(0, mockList.size());

        TodoService mockTodoService = mock(TodoService.class);
        List<String> emptyList = mockTodoService.retrieveTodosByCategory("empty");

        assertEquals(0, emptyList.size());
    }

    @Test
    void testArgumentMatchers(){
        List<String> mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn("result1").thenReturn("result2");

        assertEquals("result1", mockList.get(0));
        assertEquals("result2", mockList.get(0));
    }

    @Test
    void testVerifyInteractions() {
        TodoService mockTodoService = mock(TodoService.class);
        TodoBusinessImpl todoBusinessSUT = new TodoBusinessImpl(mockTodoService);
        when(mockTodoService.retrieveTodosByCategory(anyString())).thenReturn(Arrays.asList(
                "Wake Up",
                "Brush",
                "Learn Junit",
                "Practice Junit",
                "Sleep"));

        List<String> resultantTodos = todoBusinessSUT.retreiveRelatedTodos("Junit", "Dummy Category");

        verify(mockTodoService, times(1)).retrieveTodosByCategory(anyString());
    }

    @Test
    void testArgumentCaptors(){
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        TodoService mockTodoService = mock(TodoService.class);
        TodoBusinessImpl todoBusinessSUT = new TodoBusinessImpl(mockTodoService);
        when(mockTodoService.retrieveTodosByCategory(anyString())).thenReturn(Arrays.asList(
                "Wake Up",
                "Brush",
                "Learn Junit",
                "Practice Junit",
                "Sleep"));

        List<String> resultantTodos = todoBusinessSUT.retreiveRelatedTodos("Junit", "Dummy Category");

        verify(mockTodoService, times(1)).retrieveTodosByCategory(argumentCaptor.capture());

        assertEquals("Dummy Category", argumentCaptor.getValue());
    }

}
