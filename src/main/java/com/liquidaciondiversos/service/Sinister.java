package com.liquidaciondiversos.service;

import com.liquidaciondiversos.model.Policy;
import com.liquidaciondiversos.model.ProductWarranty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Data
@Component
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
