package helloworld.liquidaciondiversos;

import java.util.List;

public class LiquidationResult {
    private List<LiquidationDetail> details;
    private double total;

    public LiquidationResult(List<LiquidationDetail> details, double total) {
        this.details = details;
        this.total = total;
    }

    public List<LiquidationDetail> getDetails() {
        return details;
    }

    public double getTotal() {
        return total;
    }

    public void setDetails(List<LiquidationDetail> details) {
        this.details = details;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

