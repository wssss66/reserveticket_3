package reserveticket.domain;

import java.util.*;
import lombok.*;
import reserveticket.domain.*;
import reserveticket.infra.AbstractEvent;

@Data
@ToString
public class OutOfStock extends AbstractEvent {

    private Long id;
    private Long stock;
    private Integer qty;
    private String userid;
    private Long customer;
    private Long reserveid;
}
