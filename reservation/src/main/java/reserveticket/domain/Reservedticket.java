package reserveticket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserveticket.domain.*;
import reserveticket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Reservedticket extends AbstractEvent {

    private Long id;
    private String name;
    private String userid;
    private Integer qty;
    private Double amount;
    private Long customer;
    private String ticketid;

    public Reservedticket(Reservation aggregate) {
        super(aggregate);
    }

    public Reservedticket() {
        super();
    }
}
//>>> DDD / Domain Event
