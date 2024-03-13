package com.liquidaciondiversos.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Client {
    private int id;
    private String name;
    private String surname;
    private String direction;
    private String telephone;
    private String nif;
    private Warranty warranty;

}
