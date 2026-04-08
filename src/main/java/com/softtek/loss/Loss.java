package com.softtek.loss;

import com.softtek.goods.Good;
import com.softtek.policy.Policy;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Loss {
    private String lossNumber;
    private Policy policy;
    private LocalDate lossDate;
    private LocalDate reportDate;
    private String description;
    private Double lossAmount;
    private LossStatus lossStatus;
    private List<LossWarranty> lossWarranties;
    private List<Good> goods;
}
