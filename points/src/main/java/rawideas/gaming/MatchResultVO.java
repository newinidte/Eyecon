package rawideas.gaming;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "game_audit_result")
public class MatchResultVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;		
	private String player1Action;	
	private String player2Action;
	
	private String  winnerPlayer;
		
	
	
	/**
	 * 
	 */
	public MatchResultVO() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param id
	 * @param player1Action
	 * @param player2Action
	 * @param winnerPlayer
	 */
	public MatchResultVO(Integer id, String player1Action, String player2Action, String winnerPlayer) {
		super();
		this.id = id;
		this.player1Action = player1Action;
		this.player2Action = player2Action;
		this.winnerPlayer = winnerPlayer;
	}



	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**
	 * @return the player1Action
	 */
	public String getPlayer1Action() {
		return player1Action;
	}



	/**
	 * @param player1Action the player1Action to set
	 */
	public void setPlayer1Action(String player1Action) {
		this.player1Action = player1Action;
	}



	/**
	 * @return the player2Action
	 */
	public String getPlayer2Action() {
		return player2Action;
	}



	/**
	 * @param player2Action the player2Action to set
	 */
	public void setPlayer2Action(String player2Action) {
		this.player2Action = player2Action;
	}



	/**
	 * @return the winnerPlayer
	 */
	public String getWinnerPlayer() {
		return winnerPlayer;
	}



	/**
	 * @param winnerPlayer the winnerPlayer to set
	 */
	public void setWinnerPlayer(String winnerPlayer) {
		this.winnerPlayer = winnerPlayer;
	}



	
}
