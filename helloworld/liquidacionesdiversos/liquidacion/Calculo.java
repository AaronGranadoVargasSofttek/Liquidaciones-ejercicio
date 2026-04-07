package helloworld.liquidaciondiversos.helloworld.liquidacionesdiversos.liquidacion;

import helloworld.liquidaciondiversos.Product;
import helloworld.liquidaciondiversos.ProductWarranty;
import helloworld.liquidaciondiversos.loss.LossWarranty;

import java.util.Map;

public interface Calculo {
    Double calcular(ProductWarranty productWarranty, Product product, Double damageCost, LossWarranty lw);
}

