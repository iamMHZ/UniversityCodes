package jUnitTest;

import org.junit.Assert;
import org.junit.Test;

import model.TournomentSchedule;

public class TournomentTest {
	private final int number = 4;
	private final TournomentSchedule schedule = new TournomentSchedule(number);

	@Test
	public void TestARange() {
		// using TestTable class:

		for (int i = 2; i <= 200; i++) {

			int[][] table = schedule.startScheduling(i, 1, i);

			TestTable testTable = new TestTable(table, i);

			boolean check = testTable.checkEveryTeamPlaysOnceDayly();
			Assert.assertTrue(check);

			Assert.assertTrue(testTable.checkEveryTeamPlaysWithAllOthers());
		}

	}

	@Test
	public void testTableForTwo() {

		int[][] expect = { { 1, 2 }, { 2, 1 } };
		int[][] table = schedule.startScheduling(2, 1, 2);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}

//		TestTable testTable = new TestTable(table);
//
//		Assert.assertTrue(testTable.checkEveryTeamPlaysOnceDayly());
//		Assert.assertTrue(testTable.checkEveryTeamPlaysWithAllOthers());
	}

	@Test

	public void TestTableForThree() {

		int[][] expect = { { 1, 2, 3, -1 }, { 2, 1, -1, 3 }, { 3, -1, 1, 2 }, { -1, -1, -1, -1 }, };

		int[][] table = schedule.startScheduling(3, 1, 3);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}

	}

	@Test

	public void TestTableForFour() {

		int[][] expect = { { 1, 2, 3, 4 }, { 2, 1, 4, 3 }, { 3, 4, 1, 2 }, { 4, 3, 2, 1 }, };

		int[][] table = schedule.startScheduling(4, 1, 4);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}

	}

	@Test
	public void testTableForFive() {
		int[][] expect = { { 1, 2, 3, 4, -1, 5 }, { 2, 1, 5, 3, 4, -1 }, { 3, -1, 1, 2, 5, 4 }, { 4, 5, -1, 1, 2, 3 },
				{ 5, 4, 2, -1, 3, 1 }, { -1, -1, -1, -1, -1, -1 } };

		int[][] table = schedule.startScheduling(5, 1, 5);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}
	}

	@Test
	public void testTableForSix() {

		int[][] expect = { { 1, 2, 3, 4, 6, 5 }, { 2, 1, 5, 3, 4, 6 }, { 3, 6, 1, 2, 5, 4 }, { 4, 5, 6, 1, 2, 3 },
				{ 5, 4, 2, 6, 3, 1 }, { 6, 3, 4, 5, 1, 2 } };

		int[][] table = schedule.startScheduling(6, 1, 6);

		for (int i = 0; i < table.length; i++) {
			Assert.assertArrayEquals(expect[i], table[i]);
		}
	}

}
