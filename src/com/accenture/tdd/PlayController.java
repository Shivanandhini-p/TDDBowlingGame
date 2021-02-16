package com.accenture.tdd;

import java.util.ArrayList;

public class PlayController {

	private final int MAXIMUM_ROLLS = 24;
	private final int MAX_PIN_DOWNS = 10;
	private final int BONUS_SCORE_10 = 10;
	private final int BONUS_SCORE_20 = 20;

	ArrayList<Integer> frameScoreList = new ArrayList<Integer>();
	int[] rollsScore = new int[MAXIMUM_ROLLS];
	int rollcount = 0;

	public int playGame(int pinsDown) {
		if (rollcount > 22) {
			throw new ArrayIndexOutOfBoundsException("Game is Over");
		}
		rollsScore[rollcount++] = pinsDown;
		if (pinsDown == MAX_PIN_DOWNS) {
			rollsScore[rollcount++] = 0;
		}
		return pinsDown;
	}

	public int getTotalScore() {
		int totalScore = 0;
		int rollIndex = 0;
		for (int frame = 0; frame < 10; frame++) {
			if (isStrike(rollIndex)) {
				if (isDoubleStrike(rollIndex)) {
					totalScore += BONUS_SCORE_20 + rollsScore[rollIndex + 4];
				} else {
					totalScore += BONUS_SCORE_10 + rollsScore[rollIndex + 2] + rollsScore[rollIndex + 3];
				}
			} else if (isSpare(rollIndex)) {
				totalScore += BONUS_SCORE_10 + rollsScore[rollIndex + 2];
			} else {
				totalScore += rollsScore[rollIndex] + rollsScore[rollIndex + 1];
			}
			rollIndex += 2;
			frameScoreList.add(totalScore);
		}

		return totalScore;
	}

	private boolean isSpare(int rollIndex) {
		return rollsScore[rollIndex] + rollsScore[rollIndex + 1] == 10;
	}

	private boolean isStrike(int rollIndex) {
		return rollsScore[rollIndex] == 10;
	}

	private boolean isDoubleStrike(int rollIndex) {
		return rollsScore[rollIndex + 2] == 10;
	}

	public int getFrameScore(int frameNumber) {
		return frameScoreList.get(frameNumber - 1);
	}
}
