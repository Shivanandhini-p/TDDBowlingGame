package com.accenture.tdd;

import java.util.ArrayList;
import java.util.HashMap;

public class BowlingGameController {

	static int MAXIMUM_FRAMES = 10;

	int framenumber = 0;
	int totalScore = 0;
	private ArrayList<Integer> frameScoreList = new ArrayList<Integer>(MAXIMUM_FRAMES);

	private HashMap<Integer, ArrayList<Integer>> storeScoreValues = new HashMap<>();

	public int getFrameScore(int frameNumber) {
		return frameScoreList.get(frameNumber - 1);
	}

	public void playGame(int rolls1, int rolls2) {
		checkIfGameisOver();
		int scorePerFrame = rolls1 + rolls2;
		totalScore += scorePerFrame;
		frameScoreList.add(scorePerFrame);
		storeScoreValues.put(framenumber + 1, frameScoreList);
	}

	public void checkIfGameisOver() {
		int frameSize = frameScoreList.size();
		if (frameSize > 9) {
			System.out.println("Game is Over");
		}
	}

	public int getTotalScore() {
		return totalScore;
	}
}
