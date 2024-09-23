package reserveticket.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import reserveticket.domain.*;
import reserveticket.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class Deacreaedpoint extends AbstractEvent {

    private Long id;
    private String userid;
    private Long customer;
    private Integer point;

    public Deacreaedpoint(Point aggregate) {
        super(aggregate);
    }

    public Deacreaedpoint() {
        super();
    }
}
//>>> DDD / Domain Event
