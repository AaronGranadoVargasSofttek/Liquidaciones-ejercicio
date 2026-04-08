package helloworld.liquidaciondiversos.realValueCalculator;

public class realValueCalculatorImpl implements realValueCalculator
{
    private static final float AMORTIZATION_YEARS = 7;

    @Override
    public double calc(int purchaseValue, int antiquity)
    {
        double percentage = (double) Math.max(0.1, (AMORTIZATION_YEARS - antiquity) / AMORTIZATION_YEARS);
        return purchaseValue * percentage;
    }
}
