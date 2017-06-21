package rawideas.gaming;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamingService {
	
	@Autowired
	GamingRepo gamingrepo;
	@Autowired
	ScoringRepo scoringRepo;
	
	/**
	 * @return Get all details of the match
	 */
	public List<MatchResultVO> findAll(){
		return (List<MatchResultVO>) gamingrepo.findAll();
		
	}
	
	/**
	 * Save game and score deatils
	 * @param gameDetailsVO
	 */
	public void SaveGamePoints(MatchResultVO gameDetailsVO){		
		
		 scoringRepo.save(gameDetailsVO);
	
	}

}
