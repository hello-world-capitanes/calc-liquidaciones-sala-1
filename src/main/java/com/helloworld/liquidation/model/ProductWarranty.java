package com.helloworld.liquidation.model;

import com.helloworld.liquidation.model.enums.PaymentType;
import lombok.Data;

@Data
public class ProductWarranty { // garantia asociada a un producto
    private Risk risk; // riesgo
    private Warranty warranty;
    private boolean excluded; // garantia excluida
    private PaymentType paymentType; // forma de calculo
    private double capitalInsured;
    private Data date;
}
