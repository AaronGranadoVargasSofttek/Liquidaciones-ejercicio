package helloworld.liquidaciondiversos.helloworld.liquidacionesdiversos.liquidacion;

import helloworld.liquidaciondiversos.Product;
import helloworld.liquidaciondiversos.ProductWarranty;

import java.util.Map;

public interface Calculo {
    Integer calcular(ProductWarranty productWarranty, Product product, Double damageCost);
}
