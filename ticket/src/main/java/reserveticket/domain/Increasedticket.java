package reserveticket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserveticket.domain.*;
import reserveticket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Increasedticket extends AbstractEvent {

    private Long id;
    private Long stock;
    private Integer qty;
    private String userid;
    private Long customer;

    public Increasedticket(Ticket aggregate) {
        super(aggregate);
    }

    public Increasedticket() {
        super();
    }
}
//>>> DDD / Domain Event
