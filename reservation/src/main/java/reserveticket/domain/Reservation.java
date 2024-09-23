package reserveticket.domain;

import reserveticket.domain.Reservedticket;
import reserveticket.domain.Canceledticket;
import reserveticket.ReservationApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name="Reservation_table")
@Data

//<<< DDD / Aggregate Root
public class Reservation  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    private Long id;
    
    
    
    
    private String name;
    
    
    
    
    private String userid;
    
    
    
    
    private String ticketid;
    
    
    
    
    private Integer qty;
    
    
    
    
    private Double amount;
    
    
    
    
    private Long customer;

    @PostPersist
    public void onPostPersist(){


        Reservedticket reservedticket = new Reservedticket(this);
        reservedticket.publishAfterCommit();



        Canceledticket canceledticket = new Canceledticket(this);
        canceledticket.publishAfterCommit();

    
    }

    public static ReservationRepository repository(){
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(ReservationRepository.class);
        return reservationRepository;
    }



    public void reserveticket(){
        //implement business logic here:
        
        Reservedticket reservedticket = new Reservedticket(this);
        reservedticket.publishAfterCommit();
        
        
    }
    public void canceledTicket(){
        //implement business logic here:
        
        Canceledticket canceledticket = new Canceledticket(this);
        canceledticket.publishAfterCommit();
        
        
        reserveticket.external.ReservationQuery reservationQuery = new reserveticket.external.ReservationQuery();
        ReservationApplication.applicationContext
            .getBean(reserveticket.external.Service.class)
            .( reservationQuery);
    }



}
//>>> DDD / Aggregate Root
