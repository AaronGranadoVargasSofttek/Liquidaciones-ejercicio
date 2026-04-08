package com.softtek.calculo.impl;


import com.softtek.calculo.Calculo;
import com.softtek.loss.LossWarranty;
import com.softtek.payment.PaymentType;
import com.softtek.product.Product;
import com.softtek.product.ProductWarranty;
import lombok.Setter;

public class CalcularPorValoracion implements Calculo {

    @Setter
    private Proceso proceso;

    @Override
    public Double calcular(ProductWarranty productWarranty, Product product, Double damageCost, LossWarranty lw) {
        PaymentType paymentType = productWarranty.getPaymentType();

        return switch (paymentType) {
            case PRIMER_RIESGO -> primerRiesgo(productWarranty, damageCost);
            case VALOR_REAL -> valorReal(lw);
            case REPOSICION_NUEVO -> reposicionNuevo(lw);
            default -> 0.0;
        };
    }

    public Double primerRiesgo(ProductWarranty productWarranty, Double damageCost) {
        double damage = damageCost;
        double maximo = productWarranty.getCapitalInsured();
        return Math.min(damage, maximo);
    }

    public Double valorReal(LossWarranty lw) {
        double costeInicial = lw.getValorInicial();
        int antiguedad = lw.getAntiguedad();

        double depreciacionAnual = 1.0 / 7.0;
        double porcentajeDepreciado = antiguedad * depreciacionAnual;
        double valorCalculado = costeInicial * (1 - porcentajeDepreciado);

        double valorMinimo = costeInicial * 0.10;
        return Math.max(valorCalculado, valorMinimo);
    }

    public Double reposicionNuevo(LossWarranty lw) {
        return lw.getValorNuevo();
    }
}

