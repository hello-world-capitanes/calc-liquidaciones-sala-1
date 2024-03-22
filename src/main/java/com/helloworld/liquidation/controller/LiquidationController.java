package com.helloworld.liquidation.controller;


import com.helloworld.liquidation.model.Policy;
import com.helloworld.liquidation.model.Sinister;
import com.helloworld.liquidation.service.ILiquidationService;
import com.helloworld.liquidation.service.LiquidationService;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Controller
public class LiquidationController {

    private ILiquidationService liquidation;

    public LiquidationController(){
        liquidation = new LiquidationService();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema automatizado de pólizas.");

        boolean finalizar = false;
        while (!finalizar) {
            Sinister sinister = null;
            try {
                sinister = createSinister();
            } catch (ParseException e) {
                System.err.println("Error al crear el siniestro: " + e.getMessage());
            }

            if (sinister != null) {
                calculateLiquidation(sinister);
            }

            System.out.println("¿Desea finalizar? (Sí/No)");
            String respuesta = scanner.next();
            finalizar = respuesta.equalsIgnoreCase("Sí");
        }

        System.out.println("Gracias por utilizar el sistema automatizado de pólizas. ¡Hasta luego!");
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


    private void calculateLiquidation(Sinister sinister) {
        liquidation.calculoLiquidaciones(sinister);
    }


}
