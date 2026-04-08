package com.softtek.liquidation;


import com.softtek.loss.LossWarranty;

public class LiquidationDetail {
    private LossWarranty lossWarranty;
    private double amount;
    private String comment;

    public LiquidationDetail(LossWarranty lossWarranty, double amount, String comment) {
        this.lossWarranty = lossWarranty;
        this.amount = amount;
        this.comment = comment;
    }

    public LossWarranty getLossWarranty() {
        return lossWarranty;
    }

    public double getAmount() {
        return amount;
    }

    public String getComment() {
        return comment;
    }

    public void setLossWarranty(LossWarranty lossWarranty) {
        this.lossWarranty = lossWarranty;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

