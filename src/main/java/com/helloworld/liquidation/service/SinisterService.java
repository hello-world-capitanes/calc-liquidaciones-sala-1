package com.helloworld.liquidation.service;

import com.helloworld.liquidation.example.BaseData;
import com.helloworld.liquidation.model.*;

import org.springframework.stereotype.Service;

@Service
public class SinisterService {

    private final BaseData baseData;

    public SinisterService() {
        this.baseData = new BaseData();
    }

    public void createSinister(Sinister sinister){
        this.baseData.putSinister(sinister);
    }
}
