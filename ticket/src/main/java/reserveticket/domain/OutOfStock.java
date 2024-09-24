package reserveticket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserveticket.domain.*;
import reserveticket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class OutOfStock extends AbstractEvent {

    private Long id;
    private Long stock;
    private Integer qty;
    private String userid;
    private Long customer;
    private Long reserveid;
    private Long orderid;

    public OutOfStock(Ticket aggregate) {
        super(aggregate);
    }

    public OutOfStock() {
        super();
    }
}
//>>> DDD / Domain Event
