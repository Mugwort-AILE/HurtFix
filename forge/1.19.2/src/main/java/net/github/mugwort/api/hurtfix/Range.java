package net.github.mugwort.api.hurtfix;

public class Range {
    final double min;
    final double max;
    public Range(double min,double max){
        this.min = min;
        this.max = max;
    }
    public double getMax() {
        return max;
    }

    public double getMin() {
        return min;
    }

    public static Range toRange(String str){
        String[] parts = str.split("\\s*~\\s*");
        return new Range(Double.parseDouble(parts[0]),Double.parseDouble(parts[2]));
    }

    @Override
    public String toString() {
        return  min + " ~ " + max;
    }
}
