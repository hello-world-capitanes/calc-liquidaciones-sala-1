package liquidaciondiversos.service;
import liquidaciondiversos.example.BaseData;
import liquidaciondiversos.model.Sinister;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Liquidation implements ILiquidation{

    private Sinister sinister;
    private double liquidation;
    private BaseData baseData;

    public Liquidation(Sinister sinister) {
        this.sinister = sinister;
        this.liquidation = 0;
        this.baseData = new BaseData();
    }

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

    public boolean searchCode(String code){
        Map<String, Sinister> siniestros = baseData.getSinisters();
        for(int i =0; i<baseData.getSinisters(); i++){
            if(siniestros.containsKey(code)){
                sinister = siniestros.get(code);
                return true;
            }
        }
        return false;
    }

    public double getLiquidation(){
        return liquidation;
    }
}
