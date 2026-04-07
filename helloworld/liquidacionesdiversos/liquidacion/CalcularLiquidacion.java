package helloworld.liquidaciondiversos.helloworld.liquidacionesdiversos.liquidacion;

import helloworld.liquidaciondiversos.Product;
import helloworld.liquidaciondiversos.ProductWarranty;
import lombok.Setter;

import java.util.List;
import java.util.Map;

public class CalcularLiquidacion {

    private Integer liquidacionTotal;
    @Setter
    private Calculo calculo;

    private Map<Product, Integer> desglose;

    public Map<Product, Integer> calcularLiquidacion(Product product, Double damageCost) {

        List<ProductWarranty> productWarrantyList = product.getProductWarranties();

        for (ProductWarranty productWarranty : productWarrantyList) {

            liquidacionTotal = liquidacionTotal + calculo.calcular(productWarranty, product);

            if (productWarranty.isExcluded())
                desglose.put(product, 0);

            desglose.put(product, calculo.calcular(productWarranty, product));
        }

        return desglose;
    }
}
