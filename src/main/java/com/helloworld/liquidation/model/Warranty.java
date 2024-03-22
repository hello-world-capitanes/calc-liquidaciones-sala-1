package com.helloworld.liquidation.model;


import com.helloworld.liquidation.model.enums.WarrantyType;
import lombok.Data;

@Data
public class Warranty {
    private String code;
    private String name;
    private WarrantyType warrantyType;
}
