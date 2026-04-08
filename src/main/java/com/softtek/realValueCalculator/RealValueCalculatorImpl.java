package com.softtek.realValueCalculator;

public class RealValueCalculatorImpl implements RealValueCalculator
{
    private static final float AMORTIZATION_YEARS = 7;

    @Override
    public double calc(int purchaseValue, int antiquity)
    {
        double percentage = (double) Math.max(0.1, (AMORTIZATION_YEARS - antiquity) / AMORTIZATION_YEARS);
        return purchaseValue * percentage;
    }
}
