package liquidaciondiversos.service;
import liquidaciondiversos.model.Sinister;
import org.springframework.stereotype.Service;

@Service
public class Liquidation implements ILiquidation{

    private Sinister sinister;
    private double liquidation;
    
    public void calculoLiquidaciones(){
        comprobarExcluida();
        calcularTipoValoracion();
        calcularTipoAseguramiento();
        calcularInfraSeguro();
    }

    public void calcularInfraSeguro() {
    }

    public void calcularTipoAseguramiento() {
    }

    public void calcularTipoValoracion() {
    }

    public void comprobarExcluida() {
    }
}
