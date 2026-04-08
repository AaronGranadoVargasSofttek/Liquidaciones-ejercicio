package com.softtek.product;

import com.softtek.payment.PaymentType;
import com.softtek.risk.Risk;
import com.softtek.warranty.Warranty;
import lombok.Data;

@Data
public class ProductWarranty {
    private Risk risk;
    private Warranty warranty;
    private boolean excluded;
    private PaymentType paymentType;
    private double capitalInsured;
}
