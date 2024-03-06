package liquidaciondiversos.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Sinister {
    private String code;
    private Policy policy;
    private Date date;
    private String cause;
    private List<ProductWarranty> damagedList;
}
