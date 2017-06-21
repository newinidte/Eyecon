package rawideas.gaming;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface ScoringRepo extends CrudRepository<MatchResultVO, Integer> {

}
