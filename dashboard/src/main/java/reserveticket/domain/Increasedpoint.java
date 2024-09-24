package reserveticket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import reserveticket.infra.AbstractEvent;

@Data
public class Increasedpoint extends AbstractEvent {

    private Long id;
    private String userid;
    private Long customer;
    private Integer point;
    private String pointstatus;
    private Long orderid;
}
