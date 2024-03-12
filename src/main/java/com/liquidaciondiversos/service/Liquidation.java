package com.liquidaciondiversos.service;


import com.liquidaciondiversos.example.BaseData;
import com.liquidaciondiversos.model.Policy;
import com.liquidaciondiversos.model.ProductWarranty;
import com.liquidaciondiversos.model.Sinister;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

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
        calcularInfraSeguro();
        printLiquidation();
    }

    private void printLiquidation() {
        System.out.println("Siniestro: " + getSinister() +
                " - Importe total de liquidación: " + getLiquidation());
    }

    private void calcularInfraSeguro() {
    }

    private void calcularTipoValoracion() {
        for (ProductWarranty warranty : sinister.getDamagedList()){
            double importe = 0;
            switch (warranty.getPaymentType()){
                case PRIMER_RIESGO:
                    importe = calcularPrimerRiesgo(warranty);
                    break;
                case REPOSICION_NUEVO:
                    importe = calcularReposicionNuevo(warranty);
                    break;
                case VALOR_REAL:
                    importe = calularValorReal(warranty);
            }
            liquidation += importe;
        }
    }

    private double calularValorReal(ProductWarranty warranty) {
        double valor = warranty.getCapitalInsured();
        double depreciationAnnual = 1.0/7;
        Data datePurchase = warranty.getDate();
        Data dateSinister = (Data) sinister.getDate();

        long age = ChronoUnit.YEARS.between((Temporal) datePurchase, (Temporal) dateSinister);

        double residual = valor * 0.1;

        double acutal = valor;
        for(int i=0; i<age; i++){
            acutal -= acutal*depreciationAnnual;
        }

        liquidation = Math.max(acutal, residual);
        return liquidation;
    }

    private double calcularReposicionNuevo(ProductWarranty warranty) {
        liquidation += warranty.getCapitalInsured();
        return liquidation;
    }

    private double calcularPrimerRiesgo(ProductWarranty warranty) {
        double valor = warranty.getCapitalInsured();

        double importe = Math.max(valor, calcularToalDanos());
        liquidation += importe;
        return liquidation;
    }

    private double calcularToalDanos() {
        double total = 0;

        for(ProductWarranty damaged: sinister.getDamagedList()){
            total += damaged.getCapitalInsured();
        }

        return total;
    }

    private void comprobarExcluida() {
        for(ProductWarranty warranty : sinister.getDamagedList()){
            if(warranty.isExcluded()){
                liquidation = 0;
                return;
            }
        }
    }


    public Policy searchCode(int code){
        Map<Integer, Policy> poliza = baseData.getPolicies();
        Policy policy = poliza.get(code);
        if(policy !=null){
            return policy;
        }
        return null;
    }

    public Sinister getSinister() {
        return sinister;
    }

    public void setSinister(Sinister sinister) {
        this.sinister = sinister;
    }

    private double getLiquidation() {
        return liquidation;
    }



}
