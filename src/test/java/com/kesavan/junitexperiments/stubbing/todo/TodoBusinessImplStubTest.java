package com.kesavan.junitexperiments.stubbing.todo;

import com.kesavan.junitexperiments.stubbing.todo.service.TodoServiceStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TodoBusinessImplStubTest {

    @Test
    void testTodoServiceWithStub(){

        // Note that we are instatiating the SUT with a Stub dependent.
        // This stub is expected to be used for only unit testing.
        TodoBusinessImpl todoBusinessSUT = new TodoBusinessImpl(new TodoServiceStub());

        List<String> resultantTodos = todoBusinessSUT.retreiveRelatedTodos("Junit", "Dummy Category");
        assertFalse(resultantTodos.isEmpty());
        assertEquals(2, resultantTodos.size());
    }

}
