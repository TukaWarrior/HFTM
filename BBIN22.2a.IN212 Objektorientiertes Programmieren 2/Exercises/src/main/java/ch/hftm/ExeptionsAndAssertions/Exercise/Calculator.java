package ch.hftm.ExeptionsAndAssertions.Exercise;

public class Calculator {

    public static double division(int num1, int num2) throws DivisionFailedExeption {

        if (num2 == 0) {
            throw new DivisionFailedExeption("Operand 1: " + num1 + ", Operand 2: " + num2);
        }
        double result = (double) num1 /num2;
        return result;
    }
}
