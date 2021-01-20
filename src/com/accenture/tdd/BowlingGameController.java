package com.accenture.tdd;

import java.awt.List;
import java.util.ArrayList;

public class BowlingGameController {

	static int MAXIMUM_FRAMES = 10;
	static int MAXIMUM_ROLLS = 20;

	int frameCounter = 0;
	int rollCount = 0;
	int[] rolls = new int[MAXIMUM_ROLLS];
	int[] frameScore = new int[MAXIMUM_FRAMES];
	ArrayList<Integer> frameScoreList = new ArrayList<Integer>();
	int totalScore = 0;

	public int calculateScoreForEveryRoll() {
		int score = 0;
		int frameCounter = 0;
		// for (int frame = 0; frame < 10; frame++) {

		for (int rollsCounter = 0; rollsCounter < rolls.length; rollsCounter++) {
			// score += rolls[rollsCounter];
			frameScore[frameCounter] = rolls[rollsCounter] + rolls[(rollsCounter + 1)];
			frameScoreList.add(frameCounter, frameScore[frameCounter]);
			totalScore += frameScore[frameCounter];
			rollsCounter++;
			frameCounter++;

			// frameCounter++;
		}

		// }
		// }
		return totalScore;
	}

	public int getFrameScore(int frameNumber) {
		int score = 0;
		// for (int frameScore : frameScoreList) {
		score = frameScoreList.get(frameNumber - 1);
		// }
		return score;
	}

	public int rollsScore(int knockedPins) {

		return rolls[rollCount++] = knockedPins;

	}

	/*
	 * public int getIndividualScoreOfFrame(int frameNumber) { int perFrameScore =
	 * 0;
	 * 
	 * if (frameScore.containsKey(frameNumber)) { do { perFrameScore =
	 * frameScore.get(frameNumber-1); rollCount++;
	 * 
	 * } while (rollCount < 2); } return perFrameScore;
	 * 
	 * }
	 */

}
