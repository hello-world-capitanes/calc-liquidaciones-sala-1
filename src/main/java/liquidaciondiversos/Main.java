package liquidaciondiversos;

import liquidaciondiversos.application.LiquidationApplication;
import liquidaciondiversos.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        LiquidationApplication liquidationApplication = context.getBean(LiquidationApplication.class);

        liquidationApplication.run();
    }
}
