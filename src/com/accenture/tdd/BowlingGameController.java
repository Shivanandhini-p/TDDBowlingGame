package com.accenture.tdd;

public class BowlingGameController {

	static int MAXIMUM_FRAMES=10;
	static int MAXIMUM_ROLLS=2;
	int totalScore=0;
	

	int frameCounter=0;
	int roll=0;
	int[] rolls = new int[2];
	int[] scoreOfFrame = new int[10];
	
	//int [][] scoreArray = new int[10][10];


	
	public int calculateScore() {

		for (int frames = 0; frames < 10; frames++) {
			totalScore= totalScore + rolls[0]+ rolls[1];
			
		}

		return totalScore;
	}

	public int rollsScore(int knockedPins) {
		return rolls[roll++]= knockedPins;
 		//return totalScore += knockedPins;
		
	}

}
