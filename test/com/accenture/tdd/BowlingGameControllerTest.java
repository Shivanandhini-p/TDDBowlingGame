package com.accenture.tdd;

import static org.junit.Assert.assertTrue;

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
	public void shouldReturnTotalScoreofPlayerWhen2RollsArePlayed() {
		int[] rolls = { 1, 4 };
		spinRolls(rolls);
		Assert.assertEquals(5, gameController.playGame());
	}

	@Test
	public void shouldReturnTotalScoreWithNextRollAsBonusWhenTheFramehadASpare() {
		int[] rolls = { 1, 4, 5, 5, 3 };
		spinRolls(rolls);
		Assert.assertEquals(18, gameController.playGame());
	}

	@Test
	public void shouldReturnTotalScoreWith2RollsAsBonuForAStrike() {
		int[] rolls = { 10, 0, 4, 3 };
		spinRolls(rolls);
		Assert.assertEquals(24, gameController.playGame());

	}

	@Test
	public void shouldReturn0ForGutterGame() {
		int[] rolls = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		spinRolls(rolls);
		Assert.assertEquals(0, gameController.playGame());
	}

	@Test
	public void shouldReturn20For1PinsDown() {
		int[] rolls = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		spinRolls(rolls);
		Assert.assertEquals(20, gameController.playGame());
	}

	/*
	 * @Test public void shouldReturn29ForSpareinFirstRollandOthers1PinsDown() {
	 * int[] rolls = { 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
	 * spinRolls(rolls); Assert.assertEquals(29, gameController.playGame()); }
	 */

	/*
	 * @Test public void
	 * shouldReturnTotalScoreWithBonusWhenTheConsecutiveFramesHasSpares() { int[]
	 * rolls = { 4, 6, 4, 6, 2}; spinRolls(rolls); Assert.assertEquals(26,
	 * gameController.playGame());
	 * 
	 * }
	 */
	/*
	 * @Test public void
	 * shouldReturnTotalScoreWith2RollsAsBonusForTwoConsecutiveStrikes() { int[]
	 * rolls = { 1, 4, 3, 5, 4, 6, 2, 0, 10, 0, 4, 3, 10, 0, 10, 0, 5, 3, 4, 5 };
	 * spinRolls(rolls); Assert.assertEquals(114, gameController.playGame());
	 * 
	 * }
	 */

	@Test
	public void shouldReturn30ForStrikeinFirstRollandOthers1PinsDown() {
		int[] rolls = { 10, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		spinRolls(rolls);
		Assert.assertEquals(30, gameController.playGame());
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void shouldReturnGameIsOver() {
		int[] rolls = { 10, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		spinRolls(rolls);
		gameController.playGame();
		assertTrue("Game is Over", true);
	}

	private void spinRolls(int[] rolls) {
		for (int pins : rolls) {
			gameController.rollsScore(pins);

		}
	}
	
	
}
