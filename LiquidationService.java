package helloworld.liquidaciondiversos;

import helloworld.liquidaciondiversos.helloworld.liquidacionesdiversos.liquidacion.Calculo;
import helloworld.liquidaciondiversos.helloworld.liquidacionesdiversos.liquidacion.calculo.CalcularPorValoracion;
import helloworld.liquidaciondiversos.loss.Loss;
import helloworld.liquidaciondiversos.loss.LossWarranty;

import java.util.ArrayList;
import java.util.List;

public class LiquidationService {

    private final Calculo calculoPorValoracion = new CalcularPorValoracion();

    public LiquidationResult calcularLiquidacion(Loss loss) {
        double total = 0.0;
        List<LiquidationDetail> details = new ArrayList<>();

        for (LossWarranty lw : loss.getLossWarranties()) {
            ProductWarranty pw = lw.getProductWarranty();

            if (pw.isExcluded()) {
                details.add(new LiquidationDetail(lw, 0.0, "Garantía excluida"));
                continue;
            }

            double baseAmount = calculoPorValoracion.calcular(pw, loss.getPolicy().getProduct(), lw.getLossAmount(), lw);

            double afterUnderinsurance = applyUnderinsurance(baseAmount, pw, lw);

            double finalAmount = applyOverinsurance(afterUnderinsurance, pw, lw);

            details.add(new LiquidationDetail(lw, finalAmount, "OK"));
            total += finalAmount;
        }

        return new LiquidationResult(details, total);
    }

    private double applyUnderinsurance(double amount, ProductWarranty pw, LossWarranty lw) {
        double capitalAsegurado = pw.getCapitalInsured();
        double valorReal = lw.getValorPreexistencia();
        if (valorReal > 0 && capitalAsegurado < valorReal) {
            return amount * (capitalAsegurado / valorReal);
        }
        return amount;
    }

    private double applyOverinsurance(double amount, ProductWarranty pw, LossWarranty lw) {
        double capitalAsegurado = pw.getCapitalInsured();
        double valorPreexistente = lw.getValorPreexistencia();
        if (valorPreexistente > 0 && capitalAsegurado < valorPreexistente) {
            return amount * (capitalAsegurado / valorPreexistente);
        }
        return amount;
    }
}

