package reserveticket.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import reserveticket.config.kafka.KafkaProcessor;
import reserveticket.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PointRepository pointRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Decreasedticket'"
    )
    public void wheneverDecreasedticket_Incresepoint(
        @Payload Decreasedticket decreasedticket
    ) {
        Decreasedticket event = decreasedticket;
        System.out.println(
            "\n\n##### listener Incresepoint : " + decreasedticket + "\n\n"
        );

        // Sample Logic //
        Point.incresepoint(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Increasedticket'"
    )
    public void wheneverIncreasedticket_DecreasePoint(
        @Payload Increasedticket increasedticket
    ) {
        Increasedticket event = increasedticket;
        System.out.println(
            "\n\n##### listener DecreasePoint : " + increasedticket + "\n\n"
        );

        // Sample Logic //
        Point.decreasePoint(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
