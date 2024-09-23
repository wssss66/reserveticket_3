package reserveticket.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserveticket.TicketApplication;
import reserveticket.domain.Decreasedticket;
import reserveticket.domain.Increasedticket;

@Entity
@Table(name = "Ticket_table")
@Data
//<<< DDD / Aggregate Root
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long stock;

    private Integer qty;

    private String userid;

    private Long customer;

    @PostPersist
    public void onPostPersist() {
        Increasedticket increasedticket = new Increasedticket(this);
        increasedticket.publishAfterCommit();

        Decreasedticket decreasedticket = new Decreasedticket(this);
        decreasedticket.publishAfterCommit();
    }

    public static TicketRepository repository() {
        TicketRepository ticketRepository = TicketApplication.applicationContext.getBean(
            TicketRepository.class
        );
        return ticketRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseTicket(Reservedticket reservedticket) {
        //implement business logic here:

        /** Example 1:  new item 
        Ticket ticket = new Ticket();
        repository().save(ticket);

        Decreasedticket decreasedticket = new Decreasedticket(ticket);
        decreasedticket.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(reservedticket.get???()).ifPresent(ticket->{
            
            ticket // do something
            repository().save(ticket);

            Decreasedticket decreasedticket = new Decreasedticket(ticket);
            decreasedticket.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void increaseticket(Canceledticket canceledticket) {
        //implement business logic here:

        /** Example 1:  new item 
        Ticket ticket = new Ticket();
        repository().save(ticket);

        Increasedticket increasedticket = new Increasedticket(ticket);
        increasedticket.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(canceledticket.get???()).ifPresent(ticket->{
            
            ticket // do something
            repository().save(ticket);

            Increasedticket increasedticket = new Increasedticket(ticket);
            increasedticket.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
