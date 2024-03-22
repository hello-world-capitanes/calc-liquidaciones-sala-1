package com.helloworld.liquidation.service;


import com.helloworld.liquidation.model.Policy;
import com.helloworld.liquidation.model.Sinister;

public interface ILiquidationService {

    void calculoLiquidaciones(Sinister sinister);
    //boolean searchCode(String code);
    Policy searchCode(int code);
    void setSinister(Sinister sinister);

}
