package com.accenture.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BowlingGameController {

	static int MAXIMUM_FRAMES = 10;
	static int MAXIMUM_ROLLS = 20;

	int totalScore = 0;
	int rollCount = 0;
	int frameCounter=0;
	int[] rolls = new int[MAXIMUM_ROLLS];
	int[] frameScore = new int[MAXIMUM_FRAMES];
   ArrayList< Integer> rollsList= new ArrayList<Integer>();
   Map< Integer,Integer> scoreValues = new HashMap<>();
   
	int strikeCounter = 0;
	int frameSize = 0;

	public int playGame() {
		
		checkIfGameIsOver(); 
		for (int roll = 0; roll < (rolls.length-1); roll++) {
			if (isStrike(roll)) {
				if (isDoubleStrike(roll)) {
					sumUpForDoubleStrike(roll);
				} else {
					sumUpForAStrike(roll);
				}
				roll++;
			} else if (isSpare(roll)) {
				sumUpForSpare(roll);
				roll +=2;
			} else {
				sumUpForRolls(roll);
				roll++;
			}
			scoreValues.put(frameCounter++, totalScore);
		}
		return totalScore;
	}

	private void checkIfGameIsOver() {
		System.out.println(getRollssize());
		if (getRollssize() > 19) {
			System.out.println("Game is Over");
		}

	}

	private void sumUpForRolls(int roll) {
		totalScore += rolls[roll] + rolls[(roll + 1)];
	}

	private void sumUpForSpare(int roll) {
		totalScore += (rolls[roll] + rolls[(roll + 1)]) + rolls[roll + 2];
	}

	private void sumUpForAStrike(int roll) {
		totalScore += 10 + rolls[roll + 2] + rolls[roll + 3];
	}

	private void sumUpForDoubleStrike(int roll) {
		totalScore += 20 + rolls[roll + 4] + rolls[roll + 5];
	}

	private boolean isSpare(int roll) {
		return rolls[roll] + rolls[roll + 1] == 10;
	}

	private boolean isDoubleStrike(int roll) {
		return rolls[roll + 2] == 10;
	}

	private boolean isStrike(int roll) {
		return rolls[roll] == 10;
	}

	public int rollsScore(int knockedPins) {
		rollsList.add(knockedPins);
		return rolls[rollCount++] = knockedPins;
	}
	
	private int getRollssize() {
		int size = rollsList.size();
		return size;
	}
}
