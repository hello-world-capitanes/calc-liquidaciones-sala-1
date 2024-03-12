package com.liquidaciondiversos.service;

import com.liquidaciondiversos.model.Policy;
import com.liquidaciondiversos.model.Sinister;

public interface ILiquidation {

    void calculoLiquidaciones();
    //boolean searchCode(String code);
    Policy searchCode(int code);
    void setSinister(Sinister sinister);

}
