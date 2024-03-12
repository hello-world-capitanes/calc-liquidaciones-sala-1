package com.liquidaciondiversos.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Policy {

    private int id;
    private Product product;
    private Client client;
}
