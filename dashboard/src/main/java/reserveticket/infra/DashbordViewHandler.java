package reserveticket.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reserveticket.config.kafka.KafkaProcessor;
import reserveticket.domain.*;

@Service
public class DashbordViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private DashbordRepository dashbordRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservedticket_then_CREATE_1(
        @Payload Reservedticket reservedticket
    ) {
        try {
            if (!reservedticket.validate()) return;

            // view 객체 생성
            Dashbord dashbord = new Dashbord();
            // view 객체에 이벤트의 Value 를 set 함
            dashbord.setOrderid(reservedticket.getId());
            dashbord.setTicketid(reservedticket.getTicketid());
            dashbord.setReservestatus("예약됨");
            dashbord.setId(reservedticket.getId());
            // view 레파지 토리에 save
            dashbordRepository.save(dashbord);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenIncreasedpoint_then_UPDATE_1(
        @Payload Increasedpoint increasedpoint
    ) {
        try {
            if (!increasedpoint.validate()) return;
            // view 객체 조회

            List<Dashbord> dashbordList = dashbordRepository.findByOrderid(
                increasedpoint.getOrderid()
            );
            for (Dashbord dashbord : dashbordList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashbord.setPointstatus("포인트추가");
                // view 레파지 토리에 save
                dashbordRepository.save(dashbord);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
