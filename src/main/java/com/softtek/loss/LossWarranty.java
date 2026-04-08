package com.softtek.loss;

import com.softtek.product.ProductWarranty;
import lombok.Data;

@Data
public class LossWarranty {
    private ProductWarranty productWarranty;
    private double lossAmount;
    private double approvedAmount;
    private boolean approved;
    private double valorNuevo;
    private double valorInicial;
    private int antiguedad;
    private double valorPreexistencia;
    private String causa;
}
