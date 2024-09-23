package reserveticket.infra;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import reserveticket.domain.*;

@RepositoryRestResource(collectionResourceRel = "dashbords", path = "dashbords")
public interface DashbordRepository
    extends PagingAndSortingRepository<Dashbord, Long> {}
