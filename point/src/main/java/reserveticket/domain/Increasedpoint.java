package reserveticket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserveticket.domain.*;
import reserveticket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Increasedpoint extends AbstractEvent {

    private Long id;
    private String userid;
    private Long customer;
    private Integer point;

    public Increasedpoint(Point aggregate) {
        super(aggregate);
    }

    public Increasedpoint() {
        super();
    }
}
//>>> DDD / Domain Event
