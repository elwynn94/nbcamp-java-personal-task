package calculator;

import java.text.DecimalFormat;
import java.math.RoundingMode;


public class CircleCalculator extends Calculator {
    public CircleCalculator() {
        super();
    }

    @Override
    public void removeResult(int index) {
        super.removeResult(index);
    }

    @Override
    public void inquiryResults() {
        super.inquiryResults();
    }

    public double calculateCircleArea(int radius) {
        double area = Math.PI * Math.pow(radius, 2);
        double roundedArea = round(area, 2);
        calculationResults.add(roundedArea);
        return roundedArea;
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        DecimalFormat df = new DecimalFormat("#." + "0".repeat(places));
        df.setRoundingMode(RoundingMode.HALF_UP);

        return Double.parseDouble(df.format(value));
    }
}
