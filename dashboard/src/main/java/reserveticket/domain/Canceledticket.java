package reserveticket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import reserveticket.infra.AbstractEvent;

@Data
public class Canceledticket extends AbstractEvent {

    private Long id;
    private String name;
    private String userid;
    private Integer qty;
    private Double amount;
    private Long customer;
    private String ticketid;
    private String status;
}
