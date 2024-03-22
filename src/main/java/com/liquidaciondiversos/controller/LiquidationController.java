package com.liquidaciondiversos.controller;

import com.liquidaciondiversos.model.Policy;
import com.liquidaciondiversos.model.Sinister;
import com.liquidaciondiversos.service.ILiquidation;
import com.liquidaciondiversos.service.Liquidation;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class LiquidationController {

    private ILiquidation liquidation;

    public LiquidationController(){
        liquidation = new Liquidation(null);
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
                calculateLiquidation();
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


    private void calculateLiquidation() {
        liquidation.calculoLiquidaciones();
    }


}
