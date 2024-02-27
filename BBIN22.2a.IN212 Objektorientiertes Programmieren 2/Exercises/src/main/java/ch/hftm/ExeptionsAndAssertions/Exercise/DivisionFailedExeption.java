package ch.hftm.ExeptionsAndAssertions.Exercise;

public class DivisionFailedExeption extends Exception {

    private String exception;
    private String operand1;
    private String operand2;

    public DivisionFailedExeption(String exception) {
        super();
        this.exception = exception;
    }

    public DivisionFailedExeption(String exception, String operand1, String operand2) {
        super();
        this.exception = exception;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }
}