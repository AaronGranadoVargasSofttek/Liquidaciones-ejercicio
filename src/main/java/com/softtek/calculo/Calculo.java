package com.softtek.calculo;


import com.softtek.loss.LossWarranty;
import com.softtek.product.Product;
import com.softtek.product.ProductWarranty;

public interface Calculo {
    Double calcular(ProductWarranty productWarranty, Product product, Double damageCost, LossWarranty lw);
}

