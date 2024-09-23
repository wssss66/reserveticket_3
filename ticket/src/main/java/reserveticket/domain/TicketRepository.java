package reserveticket.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reserveticket.domain.*;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "tickets", path = "tickets")
public interface TicketRepository
    extends PagingAndSortingRepository<Ticket, Long> {}
