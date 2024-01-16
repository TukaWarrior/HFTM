package ch.hftm.ExeptionsAndAssertions.Exercise;

import static ch.hftm.ExeptionsAndAssertions.Exercise.Calculator.division;

public class CalculatorTest {

    public static void main (String[] args) throws DivisionFailedExeption {

        System.out.println(division(10, 5));
        System.out.println(division(9, 3));
        System.out.println(division(1, 0));
    }
}
