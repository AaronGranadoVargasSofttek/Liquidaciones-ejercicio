package com.softtek.policy;

import com.softtek.loss.Loss;
import com.softtek.product.Product;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Policy {
    private String policyNumber;
    private Product product;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double annualPremium;
    private PolicyStatus status;
    private List<Loss> losses;
}
