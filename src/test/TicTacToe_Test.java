package test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import tictactoe.Mark;
import tictactoe.TicTacToeBoard;
import tictactoe.TicTacToeBoardImpl_Dalton;

public class TicTacToe_Test 
{
	// STRAIGHTFORWARD EXAMPLES
	@Test(expected = AssertionError.class)
	public void tictactoe__0_1_5_7() 
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,0); 
		ttt1.setMark(0,1); 
		ttt1.setMark(1,2);
		ttt1.setMark(2,1);

		Mark expectedMark = Mark.O;
		Mark actualMark =  ttt1.getMark(2, 1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(1, 2);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(0, 1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(0, 0);
		assertEquals(actualMark, expectedMark);

		Mark expectedWhosTurn = Mark.X;
		Mark actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);

		boolean expectedGameOver = false;
		boolean actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);

		Mark winner = ttt1.getWinner();
	}

	@Test(expected = AssertionError.class)
	public void tictactoe__3_4_1_2_8_6()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(1,0);
		ttt1.setMark(1,1);
		ttt1.setMark(0,1);
		ttt1.setMark(0,2);
		ttt1.setMark(2,2);
		ttt1.setMark(2,0);

		Mark expectedMark = Mark.X;
		Mark actualMark =  ttt1.getMark(1, 0);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(1, 1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(0, 1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(0,2);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(2,2);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(2,0);
		assertEquals(actualMark, expectedMark);

		expectedMark = null;
		actualMark =  ttt1.getMark(1,2);
		assertEquals(actualMark, expectedMark);

		expectedMark = null;
		actualMark =  ttt1.getMark(0,0);
		assertEquals(actualMark, expectedMark);

		boolean expectedGameOver = true;
		boolean actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);

		Mark expectedWinner = Mark.O;
		Mark actualWinner = ttt1.getWinner();
		assertEquals(actualWinner, expectedWinner);

		Mark expectedWhosTurn = null;
		Mark actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);

		ttt1.setMark(1,2);
	}

	@Test
	public void tictactoe__0_1_8_4_7_6_2_3_5()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,0);
		ttt1.setMark(0,1);
		ttt1.setMark(2,2);
		ttt1.setMark(1,1);
		ttt1.setMark(2,1);
		ttt1.setMark(2,0);
		ttt1.setMark(0,2);
		ttt1.setMark(1,0);
		ttt1.setMark(1,2);

		Mark expectedMark = Mark.X;
		Mark actualMark =  ttt1.getMark(0,0);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(0,1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(2,2);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(1,1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(2,1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(2,0);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(0,2);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(1,0);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(1,2);
		assertEquals(actualMark, expectedMark);

		boolean expectedGameOver = true;
		boolean actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);

		Mark expectedWinner = Mark.X;
		Mark actualWinner = ttt1.getWinner();
		assertEquals(actualWinner, expectedWinner);

		Mark expectedWhosTurn = null;
		Mark actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);
	}
	@Test
	public void tictactoe__1_0_4_2_5_3_6_7_8()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,1);
		ttt1.setMark(0,0);
		ttt1.setMark(1,1);
		ttt1.setMark(0,2);
		ttt1.setMark(1,2);
		ttt1.setMark(1,0);
		ttt1.setMark(2,0);
		ttt1.setMark(2,1);
		ttt1.setMark(2,2);

		Mark expectedMark = Mark.X;
		Mark actualMark =  ttt1.getMark(0,1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(0,0);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(1,1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(0,2);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(1,2);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(1,0);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(2,0);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(2,1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(2,2);
		assertEquals(actualMark, expectedMark);

		boolean expectedGameOver = true;
		boolean actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);

		Mark expectedWinner = null;
		Mark actualWinner = ttt1.getWinner();
		assertEquals(actualWinner, expectedWinner);

		Mark expectedWhosTurn = null;
		Mark actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);
	}
	@Test
	public void tictactoe__0_1_3_4_6()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,0);
		ttt1.setMark(0,1);
		ttt1.setMark(1,0);
		ttt1.setMark(1,1);
		ttt1.setMark(2,0);

		Mark expectedMark = Mark.X;
		Mark actualMark =  ttt1.getMark(0,0);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(0,1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(1,0);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(1,1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(2,0);
		assertEquals(actualMark, expectedMark);

		Mark expectedWhosTurn = null;
		Mark actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);

		boolean expectedGameOver = true;
		boolean actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);

		Mark expectedWinner = Mark.X;
		Mark actualWinner = ttt1.getWinner();
		assertEquals(actualWinner, expectedWinner);
	}
	@Test(expected = AssertionError.class)
	public void tictactoe__7_1_add_8_3_6()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(2,1);
		ttt1.setMark(0,1);

		Mark expectedMark = Mark.X;
		Mark actualMark =  ttt1.getMark(2,1);
		assertEquals(actualMark, expectedMark);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(0,1);
		assertEquals(actualMark, expectedMark);

		Mark expectedWhosTurn = Mark.X;
		Mark actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);

		boolean expectedGameOver = false;
		boolean actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);

		Mark actualWinner = ttt1.getWinner();

		//adds an X on the 8 cell
		ttt1.setMark(2,2);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(2,2);
		assertEquals(actualMark, expectedMark);

		expectedWhosTurn = Mark.O;
		actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);

		expectedGameOver = false;
		actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);

		actualWinner = ttt1.getWinner();

		//adds an O on the 3 cell
		ttt1.setMark(1,0);

		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(1,0);
		assertEquals(actualMark, expectedMark);

		expectedWhosTurn = Mark.X;
		actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);

		expectedGameOver = false;
		actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);

		actualWinner = ttt1.getWinner();

		//adds an X on the 6 cell
		//CHECK THIS
		ttt1.setMark(2,0);

		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(2,0);
		assertEquals(actualMark, expectedMark);

		expectedWhosTurn = null;
		actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);

		expectedGameOver = true;
		actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);
		
		Mark expectedWinner = Mark.X;
		actualWinner = ttt1.getWinner();
		assertEquals(actualWinner, expectedWinner);
		
		ttt1.setMark(0,2);
	}
	
	//EXTREME CASES
	
	@Test(expected = AssertionError.class)
	public void tictactoe__empty()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		
		Mark expectedMark = null;
		Mark actualMark =  ttt1.getMark(0,0);
		assertEquals(actualMark, expectedMark);
		
		expectedMark = null;
		actualMark =  ttt1.getMark(0,1);
		assertEquals(actualMark, expectedMark);
		
		expectedMark = null;
		actualMark =  ttt1.getMark(2,1);
		assertEquals(actualMark, expectedMark);
		
		Mark expectedWhosTurn = Mark.X;
		Mark actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);
		
		boolean expectedGameOver = false;
		boolean actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);
		
		Mark actualWinner = ttt1.getWinner();
	}
	
	@Test(expected = AssertionError.class)
	public void tictactoe__1_2_7_7()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,1);
		ttt1.setMark(0,2);
		ttt1.setMark(2,1);
		ttt1.setMark(2,1);
	}
	
	@Test(expected = AssertionError.class)
	public void tictactoe__incorrect_row_setMark()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,1);
		ttt1.setMark(3, 1);
	}
	@Test(expected = AssertionError.class)
	public void tictactoe__incorrect_column_setMark()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,1);
		ttt1.setMark(1, 3);
	}
	@Test(expected = AssertionError.class)
	public void tictactoe__incorrect_row2_setMark()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,1);
		ttt1.setMark(-3, 1);
	}
	@Test(expected = AssertionError.class)
	public void tictactoe__incorrect_column2_setMark()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,1);
		ttt1.setMark(1, -3);
	}
	@Test(expected = AssertionError.class)
	public void tictactoe__0_3_1_4_2_5()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,0);
		ttt1.setMark(1,0);
		ttt1.setMark(0,1);
		ttt1.setMark(1,1);
		ttt1.setMark(0,2);

		
		Mark expectedMark = Mark.X;
		Mark actualMark =  ttt1.getMark(0,0);
		assertEquals(actualMark, expectedMark);
		
		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(1,0);
		assertEquals(actualMark, expectedMark);
		
		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(0,1);
		assertEquals(actualMark, expectedMark);
		
		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(1,1);
		assertEquals(actualMark, expectedMark);
		
		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(0,2);
		assertEquals(actualMark, expectedMark);
		
		Mark expectedWhosTurn = null;
		Mark actualWhosTurn = ttt1.getTurn();
		assertEquals(actualWhosTurn, expectedWhosTurn);
		
		boolean expectedGameOver = true;
		boolean actualGameOver =  ttt1.isGameOver();
		assertEquals(actualGameOver, expectedGameOver);
		
		Mark expectedWinner = Mark.X;
		Mark actualWinner = ttt1.getWinner();
		assertEquals(actualWinner, expectedWinner);
		
		ttt1.setMark(1,2);
	}
	@Test
	public void tictactoe__2_0_6_7_1_3_4()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0,2);
		ttt1.setMark(0,0);
		ttt1.setMark(2,0);
		ttt1.setMark(2,1);
		ttt1.setMark(0,1);
		ttt1.setMark(1,0);
		ttt1.setMark(1,1);
		
		Mark expectedMark = Mark.X;
		Mark actualMark =  ttt1.getMark(0,2);
		assertEquals(actualMark, expectedMark);
		
		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(0,0);
		assertEquals(actualMark, expectedMark);
		
		expectedMark = Mark.X;
		actualMark =  ttt1.getMark(2,0);
		assertEquals(actualMark, expectedMark);
		
		expectedMark = Mark.O;
		actualMark =  ttt1.getMark(2,1);
		assertEquals(actualMark, expectedMark);
		
	}
	@Test(expected = AssertionError.class)
	public void testRow_less()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(-1, 2);
	}
	@Test(expected = AssertionError.class)
	public void testRow_greater()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(4, 2);
	}
	@Test(expected = AssertionError.class)
	public void testCol_less()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0, -4);
	}
	@Test(expected = AssertionError.class)
	public void testCol_greater()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0, 3);
	}
	@Test(expected = AssertionError.class)
	public void testDuplicate()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0, 2);
		ttt1.setMark(0, 1);
		ttt1.setMark(0, 2);
	}
	@Test(expected = AssertionError.class)
	public void emptyGameOver()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		Mark Winner = ttt1.getWinner();
	}
	@Test(expected = AssertionError.class)
	public void testRow_getMark_less()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.getMark(-1, 2);
	}
	@Test
	public void testgameover()
	{
		TicTacToeBoard ttt1 = new TicTacToeBoardImpl_Dalton();
		ttt1.setMark(0, 2);
		ttt1.setMark(1,1);
		ttt1.setMark(0,1);
		ttt1.setMark(1,2);
		ttt1.setMark(0,0);
		
	}
}
