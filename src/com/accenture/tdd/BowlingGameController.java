package com.accenture.tdd;

public class BowlingGameController {

	static int MAXIMUM_FRAMES = 10;
	static int MAXIMUM_ROLLS = 21;

	int frameCounter = 0;
	int rollCount = 0;
	int[] rolls = new int[MAXIMUM_ROLLS];

	public int calculateScoreForEveryRoll() {
		int score = 0;
		for (int i = 0; i < rolls.length; i++) {
			score += rolls[i];
		}
		return score;
	}

	public int rollsScore(int knockedPins) {
		return rolls[rollCount++] = knockedPins;

	}

}
