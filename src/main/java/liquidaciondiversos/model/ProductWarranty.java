package liquidaciondiversos.model;

import lombok.Data;

@Data
public class ProductWarranty { // garantia asociada a un producto
    private Risk risk; // siniestro
    private Warranty warranty;
    private boolean excluded; // garantia excluida
    private PaymentType paymentType; // forma de calculo
    private double capitalInsured;
}
