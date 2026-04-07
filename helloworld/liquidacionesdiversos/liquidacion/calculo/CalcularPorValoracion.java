package helloworld.liquidaciondiversos.helloworld.liquidacionesdiversos.liquidacion.calculo;

import helloworld.liquidaciondiversos.PaymentType;
import helloworld.liquidaciondiversos.Product;
import helloworld.liquidaciondiversos.ProductWarranty;
import helloworld.liquidaciondiversos.helloworld.liquidacionesdiversos.liquidacion.Calculo;
import helloworld.liquidaciondiversos.loss.LossWarranty;
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

