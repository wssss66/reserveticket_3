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
        condition = "headers['type']=='Reservedticket'"
    )
    public void wheneverReservedticket_Incresepoint(
        @Payload Reservedticket reservedticket
    ) {
        Reservedticket event = reservedticket;
        System.out.println(
            "\n\n##### listener Incresepoint : " + reservedticket + "\n\n"
        );

        // Sample Logic //
        Point.incresepoint(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Canceledticket'"
    )
    public void wheneverCanceledticket_DecreasePoint(
        @Payload Canceledticket canceledticket
    ) {
        Canceledticket event = canceledticket;
        System.out.println(
            "\n\n##### listener DecreasePoint : " + canceledticket + "\n\n"
        );

        // Sample Logic //
        Point.decreasePoint(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
