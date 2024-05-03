package calculator;

import java.util.Queue;
import java.util.LinkedList;

public class Calculator {
    protected Queue<Double> calculationResults;

    public Calculator() {
        calculationResults = new LinkedList<>();
    }

    public Queue<Double> getCalculationResults() {
        return calculationResults;
    }

    public void removeResult(int index) {
        this.calculationResults.remove(index);
    }

    public void inquiryResults() {
        System.out.println("연산 결과 : " + calculationResults);
    }
}
