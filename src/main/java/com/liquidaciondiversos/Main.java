package com.liquidaciondiversos;


import com.liquidaciondiversos.application.LiquidationApplication;
import com.liquidaciondiversos.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        LiquidationApplication liquidationApplication = context.getBean(LiquidationApplication.class);

        liquidationApplication.run();
    }
}
