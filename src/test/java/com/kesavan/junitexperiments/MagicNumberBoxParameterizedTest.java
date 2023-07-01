package com.kesavan.junitexperiments;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MagicNumberBoxParameterizedTest {

    @Autowired
    private MagicNumberBox magicNumberBox;

    @ParameterizedTest
    @MethodSource("provideInput")
    void testAddFunctionality(int expectedResult, int n1, int n2){
        assertEquals(5, magicNumberBox.add(n1,n2));
    }

    @Test
    void testSubFunctionality(){
        assertEquals(5, magicNumberBox.sub(7,2));
    }

    @Test
    void testMultiplyFunctionality(){
        assertEquals(14, magicNumberBox.multiply(7,2));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 6, 8})
    void testIfEven(int input){
        assertTrue(magicNumberBox.isEven(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 7, 9})
    void testIfOdd(int input){
        assertFalse(magicNumberBox.isEven(input));
    }

    @Test
    void testIfZeroIsEven(){
        // Thought it would throw an exception on divide by zero.
        // But, I realized zero is not being divided, as we are using the mod operator and the divisor is 2.
        // I would have used the following statement to cover that exception case.
        //      assertThrows(Throwable.class, () -> magicNumberBox.isEven(0));
        // Anyways just checking the case that it does not throw any exception.
        assertDoesNotThrow(() -> magicNumberBox.isEven(0));
        assertTrue(magicNumberBox.isEven(0));
    }

    private static Stream<Arguments> provideInput(){
        return Stream.of(
                Arguments.of(5, 3, 2),
                Arguments.of(8, 4, 4)
        );
    }

}
