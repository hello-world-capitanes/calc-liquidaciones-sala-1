package liquidaciondiversos.model;

import lombok.Data;

@Data
public class Policy {

    private Product product;
    private Client client;
    private double capitals;
}
