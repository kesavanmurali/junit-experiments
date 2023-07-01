package com.kesavan.junitexperiments;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BeforeAndAfterSampleTest {

    private List<Integer> numbers = new ArrayList<>();

    @BeforeAll
    static void init() {
        System.out.println("BeforeAll running...");
    }

    @BeforeEach
    public void setup() {
        System.out.println("BeforeEach running...."+numbers.size());
        numbers.add(1);
        numbers.add(2);
    }

    @Test
    void testSumList(){
        assertEquals(3, numbers.stream().reduce(Integer::sum).get());
    }

    @Test
    void testSubFunctionality(){
        assertEquals(2, numbers.stream().reduce((a,b) -> a*b).get());
    }

    @AfterEach
    void teardown() {
        System.out.println("AfterEach running....");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("AfterAll running...");
    }

}
