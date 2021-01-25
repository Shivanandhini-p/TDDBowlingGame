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
		gameController.playGame(1, 4);
		Assert.assertEquals(5, gameController.getTotalScore());
	}

	@Test
	public void shouldReturnTotalScoreofPlayerWheninFrame2() {
		gameController.playGame(1, 4);
		gameController.playGame(3, 5);
		Assert.assertEquals(13, gameController.getTotalScore());
	}

	@Test
	public void shouldReturnFrameScoreofPlayerWheninFrame2() {
		gameController.playGame(1, 4);
		gameController.playGame(3, 5);
		int frameNumber = 2;
		int actualResult = gameController.getFrameScore(frameNumber);
		Assert.assertEquals(8, actualResult);
	}

	@Test
	public void shouldReturnFrameScoreofPlayerWheninFrame10() {
		gameController.playGame(1, 4);
		gameController.playGame(3, 5);
		gameController.playGame(5, 3);
		gameController.playGame(2, 0);
		gameController.playGame(2, 6);
		gameController.playGame(0, 4);
		gameController.playGame(0, 0);
		gameController.playGame(4, 5);
		gameController.playGame(5, 5);
		gameController.playGame(8, 0);
		int frameNumber = 10;
		int actualResult = gameController.getFrameScore(frameNumber);
		Assert.assertEquals(8, actualResult);
	}

	@Test
	public void shouldReturnTotalScoreOfPlayerintheLastFrame() {
		gameController.playGame(1, 4);
		gameController.playGame(3, 5);
		gameController.playGame(5, 3);
		gameController.playGame(2, 0);
		gameController.playGame(2, 6);
		gameController.playGame(0, 4);
		gameController.playGame(0, 0);
		gameController.playGame(4, 5);
		gameController.playGame(5, 5);
		gameController.playGame(8, 0);
		Assert.assertEquals(62, gameController.getTotalScore());
	}

	@Test
	public void shouldReturnMessageWhenFrameExceeds10() {

		gameController.playGame(1, 4);
		gameController.playGame(3, 5);
		gameController.playGame(5, 3);
		gameController.playGame(2, 0);
		gameController.playGame(2, 6);
		gameController.playGame(0, 4);
		gameController.playGame(0, 0);
		gameController.playGame(4, 5);
		gameController.playGame(5, 5);
		gameController.playGame(8, 0);
		gameController.playGame(8, 0);
		assertTrue("Game is Over", true);

	}

}
