package CalculatorSolution2WithCompositeDesign;

public class Number implements ArithmeticExpression {

    private int number;
    Number(int number) {
        this.number = number;
    }

    @Override
    public int evaluate() {
        System.out.println("Number value is : " + number);
        return number;
    }
}
