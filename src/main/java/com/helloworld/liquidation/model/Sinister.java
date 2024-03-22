package com.helloworld.liquidation.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Sinister {
    private String code;
    private Policy policy;
    private Date date;
    private String cause;
    private List<ProductWarranty> damagedList;
    private String direction;

    public Sinister(String code, Policy policy, Date date, String cause, String direction) {
        this.code = code;
        this.policy = policy;
        this.date = date;
        this.cause = cause;
        this.damagedList = policy.getProduct().getProductWarranties();
        this.direction = direction;
    }
}
