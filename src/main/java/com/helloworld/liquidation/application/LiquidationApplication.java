package com.helloworld.liquidation.application;


import com.helloworld.liquidation.controller.ApiController;
import com.helloworld.liquidation.controller.LiquidationController;
import org.springframework.stereotype.Component;

@Component
public class LiquidationApplication {

    private ApiController apiController;

    public LiquidationApplication(ApiController apiController) {
        this.apiController = apiController;
    }

    public void run() {



    }
}
