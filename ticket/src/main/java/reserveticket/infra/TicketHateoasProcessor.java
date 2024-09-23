package reserveticket.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import reserveticket.domain.*;

@Component
public class TicketHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Ticket>> {

    @Override
    public EntityModel<Ticket> process(EntityModel<Ticket> model) {
        return model;
    }
}
