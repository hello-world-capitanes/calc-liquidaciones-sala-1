package com.liquidaciondiversos.application;


import com.liquidaciondiversos.model.Policy;
import com.liquidaciondiversos.service.ILiquidation;
import com.liquidaciondiversos.service.Sinister;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class LiquidationApplication {

    private final ILiquidation liquidation;

    public LiquidationApplication(ILiquidation liquidation) {
        this.liquidation = liquidation;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema automatizado de pólizas.");

        boolean finalizar = false;
        while(!finalizar){
            Sinister sinister = null;
            try {
                sinister = createSinister();
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            if(sinister != null){
                calculateLiquidation();

                printLiquidation();

            }

        }
    }

    private Sinister createSinister() throws ParseException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduzca el código del siniestro afectado: ");
        String sinistercode = scanner.nextLine().trim();

        System.out.println("Introduzca el código de póliza: ");
        int policyCode = scanner.nextInt();
        Policy policy = searchPolicy(policyCode);

        System.out.println("Introduzca la fecha del siniestro: ");
        String fechaString = scanner.nextLine().trim();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaDate = formatoFecha.parse(fechaString);

        System.out.println("Introduzca la causa del siniestro: ");
        String causa = scanner.nextLine();

        System.out.println("Introduzca la dirección del siniestro: ");
        String direccion = scanner.nextLine();

        Sinister siniestro = new Sinister(sinistercode, policy, fechaDate,causa, direccion);
        liquidation.setSinister(siniestro);

        return siniestro;
    }

    private Policy searchPolicy(int policyCode) {
        return liquidation.searchCode(policyCode);
    }

    private void printLiquidation() {
        System.out.println("Siniestro: " + liquidation.getSinister() + " - Importe total de liquidación: " + liquidation.getLiquidation());
    }

    private void calculateLiquidation() {
        liquidation.calculoLiquidaciones();
    }
}
