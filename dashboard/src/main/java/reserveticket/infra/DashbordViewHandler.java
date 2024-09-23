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
    //>>> DDD / CQRS
}
