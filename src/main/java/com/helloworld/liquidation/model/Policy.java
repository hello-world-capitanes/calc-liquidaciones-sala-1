package com.helloworld.liquidation.model;

import lombok.Data;

@Data
public class Policy {

    private int id;
    private Product product;
    private Client client;
}
