package junitTest;

import org.junit.Assert;
import org.junit.Test;

import model.TournomentSchedule;

public class TournomentTest {
	private final int number = 4;
	private final TournomentSchedule schedule = new TournomentSchedule();

	@Test
	public void testARange() {
		// using TestTable class:

		for (int i = 2; i <=60; i++) { 

			int[][] table = schedule.start(i);

			TestTable testTable = new TestTable(table, i);

			boolean check = testTable.checkEveryTeamPlaysOnceDayly();
			Assert.assertTrue(check);

			Assert.assertTrue(testTable.checkEveryTeamPlaysWithAllOthers());
		}

	} 

	@Test
	public void testTableForTwo() {

		int[][] expect = { { 1, 2 }, { 2, 1 } };
		int[][] table = schedule.start(2);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}

//		TestTable testTable = new TestTable(table);
//
//		Assert.assertTrue(testTable.checkEveryTeamPlaysOnceDayly());
//		Assert.assertTrue(testTable.checkEveryTeamPlaysWithAllOthers());
	}

	@Test

	public void testTableForThree() {

		int[][] expect = { { 1, 2, 3, -1 }, { 2, 1, -1, 3 }, { 3, -1, 1, 2 }, { -1, -1, -1, -1 }, };

		int[][] table = schedule.start(3);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}

	}

	@Test

	public void testTableForFour() {

		int[][] expect = { { 1, 2, 3, 4 }, { 2, 1, 4, 3 }, { 3, 4, 1, 2 }, { 4, 3, 2, 1 }, };

		int[][] table = schedule.start(4);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}

	}

	@Test
	public void testTableForFive() {
		int[][] expect = { { 1, 2, 3, 4, -1, 5 }, { 2, 1, 5, 3, 4, -1 }, { 3, -1, 1, 2, 5, 4 }, { 4, 5, -1, 1, 2, 3 },
				{ 5, 4, 2, -1, 3, 1 }, { -1, -1, -1, -1, -1, -1 } };

		int[][] table = schedule.start(5);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}
	}

	@Test
	public void testTableForSix() {

		int[][] expect = { { 1, 2, 3, 4, 6, 5 }, { 2, 1, 5, 3, 4, 6 }, { 3, 6, 1, 2, 5, 4 }, { 4, 5, 6, 1, 2, 3 },
				{ 5, 4, 2, 6, 3, 1 }, { 6, 3, 4, 5, 1, 2 } };

		int[][] table = schedule.start(6);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}
	}

}
