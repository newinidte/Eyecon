package rawideas.gaming;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamingController {

	@Autowired
	GamingService gamingService;
	public enum WINNER { A, B, T }

	public enum Season { ROCK, SCISSORS, PAPER }

    private static final RandomEnum<Season> r =
        new RandomEnum<Season>(Season.class);
	
	/**
	 * @return This method will arrange the details that are respective to a match and display the output in a json format.
	 */
	@RequestMapping(value = "/points", method = RequestMethod.GET,headers = "Accept=application/json")
	public List<MatchResultVO> findAll(){
		
		
		
		List<MatchResultVO> matchResultVOs = gamingService.findAll();
		
		
		return matchResultVOs;		
	}
	/**
	 * @return This method will take input from the Json and calculate the game points, winner and insert in DB
	 */
	@RequestMapping(value = "/points", method = RequestMethod.POST, headers = "Accept=application/json")
	public void insertPoints(@RequestBody MatchResultVO scoresVO){	
		String actionValue  = r.random().toString();
		if(!scoresVO.getPlayer1Action().equals(actionValue)){
			if(null == scoresVO.getPlayer2Action() || "".equals(scoresVO.getPlayer2Action())){
			if((scoresVO.getPlayer1Action().equals(Constant.PAPER) && actionValue.equals(Constant.ROCK)) || (scoresVO.getPlayer1Action().equals(Constant.ROCK) && actionValue.equals(Constant.SCISSORS)) || (scoresVO.getPlayer1Action().equals(Constant.SCISSORS) && actionValue.equals(Constant.PAPER)) ){
				
				scoresVO.setWinnerPlayer(WINNER.A.toString());
				
			}else if((scoresVO.getPlayer1Action().equals(Constant.PAPER) && actionValue.equals(Constant.SCISSORS)) || (scoresVO.getPlayer1Action().equals(Constant.ROCK) && actionValue.equals(Constant.PAPER)) || (scoresVO.getPlayer1Action().equals(Constant.SCISSORS) && actionValue.equals(Constant.ROCK))){
				
				scoresVO.setWinnerPlayer(WINNER.B.toString());			
			}
			scoresVO.setPlayer2Action(actionValue);	
			}else{
				if((scoresVO.getPlayer1Action().equals(Constant.PAPER) && scoresVO.getPlayer2Action().equals(Constant.ROCK)) || (scoresVO.getPlayer1Action().equals(Constant.ROCK) && scoresVO.getPlayer2Action().equals(Constant.SCISSORS)) || (scoresVO.getPlayer1Action().equals(Constant.SCISSORS) && scoresVO.getPlayer2Action().equals(Constant.PAPER)) ){
					
					scoresVO.setWinnerPlayer(WINNER.A.toString());
					
				}else if((scoresVO.getPlayer1Action().equals(Constant.PAPER) && scoresVO.getPlayer2Action().equals(Constant.SCISSORS)) || (scoresVO.getPlayer1Action().equals(Constant.ROCK) && scoresVO.getPlayer2Action().equals(Constant.PAPER)) || (scoresVO.getPlayer1Action().equals(Constant.SCISSORS) && scoresVO.getPlayer2Action().equals(Constant.ROCK))){
					
					scoresVO.setWinnerPlayer(WINNER.B.toString());			
				}
				scoresVO.setPlayer2Action(actionValue);	
				
			}
		}else{
				scoresVO.setWinnerPlayer(WINNER.T.toString());
				scoresVO.setPlayer2Action(actionValue);	
				
			}
		
			
	        		 gamingService.SaveGamePoints(scoresVO);
	}
	
	/**
	 * @author Ganesh
	 *
	 * @param <E>
	 */
	private static class RandomEnum<E extends Enum> {

        private static final Random RND = new Random();
        private final E[] values;

        public RandomEnum(Class<E> token) {
            values = token.getEnumConstants();
        }

        public E random() {
            return values[RND.nextInt(values.length)];
        }
    }
	
	
}
