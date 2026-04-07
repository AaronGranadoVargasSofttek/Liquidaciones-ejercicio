package helloworld.liquidaciondiversos.loss;

import helloworld.liquidaciondiversos.ProductWarranty;
import lombok.Data;

@Data
public class LossWarranty {
    private ProductWarranty productWarranty;
    private double lossAmount;
    private double approvedAmount;
    private boolean approved;
}
