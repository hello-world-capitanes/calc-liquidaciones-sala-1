package liquidaciondiversos.application;

import liquidaciondiversos.service.ILiquidation;
import org.springframework.stereotype.Component;

@Component
public class LiquidationApplication {

    private final ILiquidation liquidation;

    public LiquidationApplication(ILiquidation liquidation) {
        this.liquidation = liquidation;
    }

    public void run(){

    }
}
