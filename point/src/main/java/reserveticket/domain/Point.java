package reserveticket.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import reserveticket.PointApplication;
import reserveticket.domain.Deacreaedpoint;
import reserveticket.domain.Increasedpoint;

@Entity
@Table(name = "Point_table")
@Data
//<<< DDD / Aggregate Root
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userid;

    private Long customer;

    private Integer point;

    @PostPersist
    public void onPostPersist() {
        Increasedpoint increasedpoint = new Increasedpoint(this);
        increasedpoint.publishAfterCommit();

        Deacreaedpoint deacreaedpoint = new Deacreaedpoint(this);
        deacreaedpoint.publishAfterCommit();
    }

    public static PointRepository repository() {
        PointRepository pointRepository = PointApplication.applicationContext.getBean(
            PointRepository.class
        );
        return pointRepository;
    }

    //<<< Clean Arch / Port Method
    public static void incresepoint(Decreasedticket decreasedticket) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        Increasedpoint increasedpoint = new Increasedpoint(point);
        increasedpoint.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(decreasedticket.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            Increasedpoint increasedpoint = new Increasedpoint(point);
            increasedpoint.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void decreasePoint(Increasedticket increasedticket) {
        //implement business logic here:

        /** Example 1:  new item 
        Point point = new Point();
        repository().save(point);

        Deacreaedpoint deacreaedpoint = new Deacreaedpoint(point);
        deacreaedpoint.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(increasedticket.get???()).ifPresent(point->{
            
            point // do something
            repository().save(point);

            Deacreaedpoint deacreaedpoint = new Deacreaedpoint(point);
            deacreaedpoint.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
