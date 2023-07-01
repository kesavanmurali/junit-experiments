package com.kesavan.junitexperiments;

import org.springframework.stereotype.Component;

@Component
public class MagicNumberBox {

    public int add(int number1, int number2){
        return number1 + number2;
    }

    public int sub(int number1, int number2){
        return number1 - number2;
    }

    public int multiply(int number1, int number2) {
        return number1 * number2;
    }

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

}
