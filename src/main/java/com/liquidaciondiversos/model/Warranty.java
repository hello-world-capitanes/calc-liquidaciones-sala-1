package com.liquidaciondiversos.model;


import com.liquidaciondiversos.model.enums.WarrantyType;
import lombok.Data;

@Data
public class Warranty {
    private String code;
    private String name;
    private WarrantyType warrantyType;
}
