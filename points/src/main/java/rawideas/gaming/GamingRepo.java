package rawideas.gaming;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface GamingRepo extends CrudRepository<MatchResultVO, Integer> {

}
