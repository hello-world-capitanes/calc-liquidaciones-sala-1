package liquidaciondiversos.application;

import liquidaciondiversos.service.ILiquidation;
import org.springframework.stereotype.Component;

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
            System.out.println("Introduzca el código del siniestro afectado o salir para finalizar: ");
            String code = scanner.nextLine().trim();

            if(liquidation.searchCode(code)){
                calculateLiquidation();
                printLiquidation(code);

            }
            else if(code.equalsIgnoreCase("salir")){
                finalizar = true;
            }
        }
    }

    private void printLiquidation(String code) {
        System.out.println("Siniestro: " + code + " - Importe total de liquidación: " + liquidation.getLiquidation());
        printDesglose(code);
    }

    private void printDesglose(String code) {

    }

    private void calculateLiquidation() {
        liquidation.calculoLiquidaciones();
    }
}
