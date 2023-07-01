package com.kesavan.junitexperiments;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class MagicNumberBoxTest {

    @Autowired
    private MagicNumberBox magicNumberBox;

    @Test
    void testAddFunctionality(){
        assertEquals(5, magicNumberBox.add(3,2));
    }

    @Test
    void testSubFunctionality(){
        assertEquals(5, magicNumberBox.sub(7,2));
    }

    @Test
    void testMultiplyFunctionality(){
        assertEquals(14, magicNumberBox.multiply(7,2));
    }

    @Test
    void testIfEven(){
        assertTrue(magicNumberBox.isEven(4));
    }

    @Test
    void testIfOdd(){
        assertFalse(magicNumberBox.isEven(5));
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

}
