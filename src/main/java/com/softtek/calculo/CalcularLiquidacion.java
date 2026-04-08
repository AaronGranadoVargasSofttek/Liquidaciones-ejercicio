package com.softtek.calculo;

import com.softtek.loss.LossWarranty;
import com.softtek.product.Product;
import com.softtek.product.ProductWarranty;

import java.util.Map;

public class CalcularLiquidacion {

    private Double liquidacion;
    private Map<String, Double> desglose;
    private Calculo calculo;

    public Map<String, Double> calcular(Product product, Double damageCost, LossWarranty lossWarranty) {

        for (ProductWarranty productWarranty : product.getProductWarranties()) {

            if (productWarranty.isExcluded())
                desglose.put(product.getName(), 0.0);

            desglose.put(product.getName(), calculo.calcular(productWarranty, product, damageCost, lossWarranty));

            liquidacion = liquidacion + calculo.calcular(productWarranty, product, damageCost, lossWarranty);
        }

        return desglose;
    }
}
