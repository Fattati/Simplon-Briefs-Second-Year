package com.quiz;

public class Player {
public Player(boolean playerWinLevel1, boolean playerWinLevel2, boolean playerWinLevel3) {
		super();
		this.playerWinLevel1 = playerWinLevel1;
		this.playerWinLevel2 = playerWinLevel2;
		this.playerWinLevel3 = playerWinLevel3;
	}

public boolean isPlayerWinLevel1() {
		return playerWinLevel1;
	}

	public void setPlayerWinLevel1(boolean playerWinLevel1) {
		this.playerWinLevel1 = playerWinLevel1;
	}

	public boolean isPlayerWinLevel2() {
		return playerWinLevel2;
	}

	public void setPlayerWinLevel2(boolean playerWinLevel2) {
		this.playerWinLevel2 = playerWinLevel2;
	}

	public boolean isPlayerWinLevel3() {
		return playerWinLevel3;
	}

	public void setPlayerWinLevel3(boolean playerWinLevel3) {
		this.playerWinLevel3 = playerWinLevel3;
	}

boolean playerWinLevel1, playerWinLevel2, playerWinLevel3;
}
