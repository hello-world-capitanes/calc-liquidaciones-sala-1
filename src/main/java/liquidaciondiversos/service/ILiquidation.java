package liquidaciondiversos.service;

import liquidaciondiversos.model.ProductWarranty;

public interface ILiquidation {

    void calculoLiquidaciones();
    void comprobarExcluida();
    void calcularTipoValoracion();
    void calcularInfraSeguro();
    boolean searchCode(String code);
    double getLiquidation();
}
