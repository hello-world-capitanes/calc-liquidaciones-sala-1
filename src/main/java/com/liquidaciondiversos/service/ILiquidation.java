package com.liquidaciondiversos.service;

import com.liquidaciondiversos.model.Policy;

public interface ILiquidation {

    void calculoLiquidaciones();
    void comprobarExcluida();
    void calcularTipoValoracion();
    void calcularInfraSeguro();
    //boolean searchCode(String code);
    double getLiquidation();
    Policy searchCode(int code);
    void setSinister(Sinister sinister);
    Sinister getSinister();
}
