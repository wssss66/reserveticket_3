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
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        // Reservedticket reservedticket = new Reservedticket(this);
        // reservedticket.publishAfterCommit();



        // Canceledticket canceledticket = new Canceledticket(this);
        // canceledticket.publishAfterCommit();

    
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
        
        
        // reserveticket.external.ReservationQuery reservationQuery = new reserveticket.external.ReservationQuery();
        // ReservationApplication.applicationContext
        //     .getBean(reserveticket.external.Service.class)
        //     .( reservationQuery);
    }

//<<< Clean Arch / Port Method
    public static void updatestatus(OutOfStock outOfStock){

        repository().findById(outOfStock.getOrderid()).ifPresent(order ->{
            
            order.setStatus("OrderCancelled");
            repository().save(order);
        });
        
        //implement business logic here:

        /** Example 1:  new item 
        Reservation reservation = new Reservation();
        repository().save(reservation);

        */

        /** Example 2:  finding and process
        
        repository().findById(outOfStock.get???()).ifPresent(reservation->{
            
            reservation // do something
            repository().save(reservation);


         });
        */

        
    }
//>>> Clean Arch / Port Method


}
//>>> DDD / Aggregate Root
