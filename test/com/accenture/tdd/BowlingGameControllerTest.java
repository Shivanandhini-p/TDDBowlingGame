package com.accenture.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameControllerTest {

	public BowlingGameController gameController;

	@Before
	public void createGame() {
		gameController = new BowlingGameController();
	}

	@Test
	public void shouldReturnFinalScoreForTwoRolls() {
		int[] rolls = { 5, 5 };
		spinRolls(rolls);
		int actualResult = gameController.calculateScoreForEveryRoll();
		Assert.assertEquals(10, actualResult);
	}

	@Test
	public void shouldReturnScoreOfFirstFrameFor2Rolls() {
		int[] rolls = { 1, 4 };
		spinRolls(rolls);
		int actualResult = gameController.calculateScoreForEveryRoll();
		Assert.assertEquals(5, actualResult);

	}

	@Test
	public void shouldReturnCumulativeScoreForSecondFrame() {
		int[] rolls = { 1, 4, 3, 5 };
		spinRolls(rolls);
		int actualResult = gameController.calculateScoreForEveryRoll();
		Assert.assertEquals(13, actualResult);
	}

	@Test
	public void shouldReturnTotalScoreintheLastFrame() {
		int[] rolls = { 1, 4, 3, 5, 5, 3, 2, 0, 2, 6, 0, 4, 0, 0, 4, 5, 5, 5, 8, 0 };
		spinRolls(rolls);
		int actualResult = gameController.calculateScoreForEveryRoll();
		Assert.assertEquals(62, actualResult);
	}

	private void spinRolls(int[] rolls) {
		for (int pins : rolls) {
			gameController.rollsScore(pins);

		}
	}
}
