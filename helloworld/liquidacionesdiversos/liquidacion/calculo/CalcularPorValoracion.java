package helloworld.liquidaciondiversos.helloworld.liquidacionesdiversos.liquidacion.calculo;

import helloworld.liquidaciondiversos.PaymentType;
import helloworld.liquidaciondiversos.Product;
import helloworld.liquidaciondiversos.ProductWarranty;
import helloworld.liquidaciondiversos.helloworld.liquidacionesdiversos.liquidacion.Calculo;
import lombok.Setter;

public class CalcularPorValoracion implements Calculo {

    @Setter
    private Proceso proceso;

    @Override
    public Double calcular(ProductWarranty productWarranty, Product product, Double damageCost) {

        PaymentType paymentType = productWarranty.getPaymentType();

        return switch (paymentType) {
            case PRIMER_RIESGO -> primerRiesgo(productWarranty, product, damageCost);
            case VALOR_REAL -> valorReal(product);
            case REPOSICION_NUEVO -> reposicionNuevo(product);
            default -> 0.0;
        };
    }

    public Double primerRiesgo(ProductWarranty productWarranty, Product product,Double damageCost) {

        double damage = damageCost;
        double maximo = productWarranty.getCapitalInsured();

        return Math.min(damage, maximo);
    }

    public Double valorReal(Product product) {

        Integer costeInicial = product.getInitialCost();
        Integer antiguedad = product.getYears();

        double depreciacionAnual = 1.0 / 7.0;
        double porcentajeDepreciado = antiguedad * depreciacionAnual;
        double valorCalculado = costeInicial * (1 - porcentajeDepreciado);

        double valorMinimo = costeInicial * 0.10;

        return Math.max(valorCalculado, valorMinimo);
    }

    public Double reposicionNuevo(Product product) {
        return product.getNewValue();
    }
}