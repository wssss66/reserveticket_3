package reserveticket.domain;

import java.util.*;
import lombok.*;
import reserveticket.domain.*;
import reserveticket.infra.AbstractEvent;

@Data
@ToString
public class Canceledticket extends AbstractEvent {

    private Long id;
    private String name;
    private String userid;
    private Integer qty;
    private Double amount;
    private Long customer;
    private String ticketid;
}
