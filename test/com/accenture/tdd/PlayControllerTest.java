package com.accenture.tdd;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayControllerTest {
	PlayController playController;

	@Before
	public void setInstance() {
		playController = new PlayController();

	}

	@Test
	public void shouldReturnTheTotalScoreForFirstRoll() {
		rollPins(5);
		Assert.assertEquals(5, playController.getTotalScore());
	}

	@Test
	public void shouldReturnTheTotalScoreForTwoRolls() {
		rollPins(5);
		rollPins(4);
		Assert.assertEquals(9, playController.getTotalScore());
	}

	@Test
	public void shouldReturnTotalScoreForThreeRolls() {
		rollPins(5);
		rollPins(4);
		rollPins(5);
		Assert.assertEquals(14, playController.getTotalScore());
	}

	@Test
	public void shouldReturnTheTotalScoreForFourRolls() {
		rollPins(5);
		rollPins(4);
		rollPins(5);
		rollPins(4);
		Assert.assertEquals(18, playController.getTotalScore());
	}

	@Test
	public void shouldReturnTheTotalScoreFor20Rolls() {
		rollPins(1);
		rollPins(4);
		
		rollPins(3);
		rollPins(5);

		rollPins(5);
		rollPins(3);

		rollPins(2);
		rollPins(0);

		rollPins(2);
		rollPins(6);

		rollPins(0);
		rollPins(4);

		rollPins(0);
		rollPins(0);

		rollPins(4);
		rollPins(4);

		rollPins(5);
		rollPins(4);

		rollPins(8);
		rollPins(0);
		Assert.assertEquals(60, playController.getTotalScore());

	}

	@Test
	public void shouldReturnFrameScoreWithNextRollAsBonusForASpare() {
		rollPins(5);
		rollPins(5);
		rollPins(3);
		playController.getTotalScore();
		int frame1Score = playController.getFrameScore(1);
		Assert.assertEquals(13, frame1Score);
	}

	@Test
	public void shouldReturnTotalScoreWithNextRollAsBonusForSpares() {
		rollPins(5);
		rollPins(5); // 13
		rollPins(3);
		rollPins(5); // 8
		rollPins(4);
		rollPins(6); // 12
		rollPins(2);
		rollPins(3); // 5
		int totalScore = playController.getTotalScore();
		Assert.assertEquals(38, totalScore);
	}

	@Test
	public void shouldReturnScoreWithBonusForASpareAtThirdFrame() {
		rollPins(5);
		rollPins(5); // 13
		rollPins(3);
		rollPins(5); // 8
		rollPins(4);
		rollPins(6); // 12
		rollPins(2);
		rollPins(3); // 5
		playController.getTotalScore();
		Assert.assertEquals(33, playController.getFrameScore(3));
	}

	@Test
	public void shouldReturnTotalScoreWithBonusForFirstSpare() {
		rollPins(5);
		rollPins(5);
		Assert.assertEquals(10, playController.getTotalScore());
	}

	@Test
	public void shouldReturnFrameScoreWithNext2RollsAsBonusForAStrike() {
		rollPins(10);
		rollPins(5);
		rollPins(3);
		playController.getTotalScore();
		Assert.assertEquals(18, playController.getFrameScore(1));
	}

	@Test
	public void shouldReturnTotalScoreWithNext2RollsAsBonusForMultipleStrikes() {
		rollPins(10); // 18
		rollPins(5);
		rollPins(3); // 8
		rollPins(10); // 18
		rollPins(5);
		rollPins(3); // 8
		playController.getTotalScore();
		Assert.assertEquals(52, playController.getTotalScore());
	}

	@Test
	public void shouldReturnFrameScoreWithBonusFor2ConsecutiveStrikes() {
		rollPins(10); // 29
		rollPins(10); // 19
		rollPins(5);
		rollPins(4); // 9
		playController.getTotalScore();
		Assert.assertEquals(25, playController.getFrameScore(1));
	}

	@Test
	public void shouldReturnFrameScoreWithBonusAsNext2RollsForMultipleConsecutiveStrikes() {
		rollPins(10); // 30
		rollPins(10); // 60
		rollPins(10); // 90
		rollPins(10); // 120
		rollPins(10); // 150
		rollPins(10); // 180
		rollPins(10); // 210
		rollPins(10); // 240
		rollPins(10); // 270
		playController.getTotalScore();
		Assert.assertEquals(210, playController.getFrameScore(7));
	}

	@Test
	public void shouldReturnTenthFrameScoreWithBonusIfTenthFrameisASpare() {
		rollPins(1);
		rollPins(4);
		rollPins(3);
		rollPins(5);
		rollPins(4);
		rollPins(6);
		rollPins(2);
		rollPins(0);
		rollPins(10);// 0
		
		rollPins(4);
		rollPins(3);
		rollPins(10);// 0
		
		rollPins(10);// 0
		
		rollPins(5);
		rollPins(3);
		rollPins(10);// 0
		
		rollPins(5);
		rollPins(5);
		playController.getTotalScore();
		Assert.assertEquals(122, playController.getFrameScore(10));
	}

	@Test
	public void shouldReturnTenthFrameScoreWithBonusIfTenthFrameisAStrike() {
		rollPins(1);
		rollPins(4);

		rollPins(3);
		rollPins(5);

		rollPins(4);
		rollPins(6);

		rollPins(2);
		rollPins(0);

		rollPins(10);

		rollPins(4);
		rollPins(3);

		rollPins(10);

		rollPins(10);

		rollPins(5);
		rollPins(3);

		rollPins(7);
		rollPins(3);

		rollPins(10);
		playController.getTotalScore();
		Assert.assertEquals(122, playController.getFrameScore(10));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void shouldReturnMessageIfTenthFrameExceeds3Rolls() {
		rollPins(24, 2);
		assertTrue("Game is Over", true);
	}

	@Test
	public void shouldReturnTotalScoreIfAll10RollsPassedAreStrike_And_2ExtraRollsAreStrike() {
		rollPins(10, 10);
		rollPins(2, 10);
		Assert.assertEquals(300, playController.getTotalScore());
	}

	@Test
	public void shouldReturnTotalScoreIfAll20RollsPassedAreSpare_And_WithOneExtraRollAsSpare() {
		rollPins(20, 5);
		rollPins(1, 5);
		Assert.assertEquals(150, playController.getTotalScore());
	}

	@Test
	public void shouldReturnTotalScoreWithBonus_IfLast2RollsisStrike() {
		rollPins(16, 1);
		rollPins(2, 10);// double strike
		rollPins(1, 6);
		rollPins(1, 2);
		Assert.assertEquals(60, playController.getTotalScore());
	}
	
	private void rollPins(int rolls, int pins) {
		for (int i = 0; i < rolls; i++) {
			playController.playGame(pins);
		}
	}
	private void rollPins(int pins) {
		playController.playGame(pins);
	}

}
