package com.liquidaciondiversos.application;


import com.liquidaciondiversos.controller.LiquidationController;
import com.liquidaciondiversos.model.Policy;
import com.liquidaciondiversos.service.ILiquidation;
import com.liquidaciondiversos.model.Sinister;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class LiquidationApplication {

    private LiquidationController liquidationController;

    public LiquidationApplication(LiquidationController liquidationController) {
        this.liquidationController = liquidationController;
    }

    public void run() {

        liquidationController.run();

    }
}
