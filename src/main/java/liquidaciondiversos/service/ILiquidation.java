package liquidaciondiversos.service;

public interface ILiquidation {

    void calculoLiquidaciones();
    void comprobarExcluida();
    void calcularTipoValoracion();
    void calcularTipoAseguramiento();
    void calcularInfraSeguro();
}
