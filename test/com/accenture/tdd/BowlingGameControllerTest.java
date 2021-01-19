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
	public void shouldReturnScoreForEveryRoll() {
		int actualResult = gameController.rollsScore(1);
		Assert.assertEquals(1, actualResult);
	}

	@Test
	public void shouldReturnScoreOfFirstFrameFor2Rolls() {
		gameController.rollsScore(1);
		gameController.rollsScore(4);
		int actualResult = gameController.calculateScore();
		Assert.assertEquals(5, actualResult);

	}

	@Test
	public void shouldReturnScoreOfSecondFrameFor2Rolls() {
		gameController.rollsScore(3);
		gameController.rollsScore(5);
		int actualResult = gameController.calculateScore();
		Assert.assertEquals(13, actualResult);
	}

	@Test
	public void shouldReturnTotalScoreintheLastFrame() {
		gameController.rollsScore(8);
		gameController.rollsScore(0);
		int actualResult = gameController.calculateScore();
		Assert.assertEquals(13, actualResult);
	}
}

/*
 * 
 * @Test public void shouldReturnScoreAs10PFor2Rolls() { int actualResult =
 * gameController.rolls(2,10); Assert.assertEquals(10, actualResult); }
 * 
 * @Test public void shouldReturnScoreAs5For2Rolls() { int actualResult =
 * gameController.rolls(2,5); Assert.assertEquals(5, actualResult); }
 * 
 * @Test public void shouldReturnScoreAs13For2Rolls() { int actualResult =
 * gameController.rolls(2,5,3); Assert.assertEquals(13, actualResult); }
 */
