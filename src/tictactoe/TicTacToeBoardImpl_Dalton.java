package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

public class TicTacToeBoardImpl_Dalton implements TicTacToeBoard
{
	protected static final int NO_MOVE = -1;
	protected static final int NO_MATCH = -1;
	protected int[] movesArray;


	public TicTacToeBoardImpl_Dalton()
	{
		final int CELL_COUNT = ROW_COUNT*COLUMN_COUNT;
		movesArray = new int[CELL_COUNT];
		for(int i = 0; i < CELL_COUNT; i++)
		{
			movesArray[i] = NO_MOVE;
		}
	}
	// pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
	//post: returns an int that represents a spot/space on the tic tac toe board
	//Straightforward: identifyCell(0,2) -> 2
	//Extreme: identifyCell(-1,2) -> nuclear brocoli
	//Bizzare : identifyCell(1245,1345) -> nuclear brocoli
	private static int identifyCell(int row, int column)
	{
		int cell = 0;
		if(row == 0)
		{
			cell = column;
		}
		if(row == 1)
		{
			cell = column + 3;
		}
		if(row == 2)
		{
			cell = column + 6;
		}
		return cell;
	}
	//pre: 0 <= target <= 8
	//post: returns the index of the target found in the array
	//Straightforward: findTarget(5, [2,5,8,1,-1,-1,-1,-1,-1]) -> 1
	//Extreme: findTarget(2, [-1,-1,-1,-1,-1,-1,-1,-1,-1]) -> -1
	//Bizzare: findTarget(2, []) -> nuclear brocoli
	private static int findTarget(int target, int [] array)
	{
		int targetFound = NO_MATCH;
		for(int i = 0; i < array.length;i++)
		{
			if(array[i]== target)
			{
				targetFound = i;
				break;
			}
		}
		return targetFound;
	}
	//part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
	//part of post: rv == null <==> the (row, column) spot on the
	// board is empty
	//Straightforward : [8,6,5,2,1,-1,-1,-1,-1].getMark(2,2) -> X
	//Extreme: [-1,-1,-1,-1,-1,-1,-1,-1,-1].getMark(0,1) -> null
	//Bizzare [6,8,5,2,1,7,3,-1,-1].getMark(3,0) -> nuclear brocoli
	@Override
	public Mark getMark(int row, int column) 
	{	
		assert row >= 0 && row < ROW_COUNT : "row must be greater or equal to 0 "
				+ "and row must be less than or equal " + ROW_COUNT;
		assert column >= 0 && column < COLUMN_COUNT : "column must be greater or equal to 0 "
				+ "and row must be less than or equal " + COLUMN_COUNT;
		int cell = TicTacToeBoardImpl_Dalton.identifyCell(row, column);
		Mark aMark = null;
		int indexOfMovesArray = TicTacToeBoardImpl_Dalton.findTarget(cell, movesArray);
		if(indexOfMovesArray != -1)
		{
			if(indexOfMovesArray %2==0)
			{
				aMark = Mark.X;
			}
			if(indexOfMovesArray %2 == 1)
			{
				aMark = Mark.O;
			}
		}
		return aMark;
	}
	//part of pre: 0 <= row < ROW_COUNT && 0 <= column < COLUMN_COUNT
	//part of pre: getMark(row, column) == null
	//part of pre: !isGameOver()
	//post: enters a cell number from 0 to 8 in the movesArray
	//StraightForward: [8,1,-1,-1,-1,-1,-1,-1,-1].setMark(0,2) -> [8,1,2,-1,-1,-1,-1,-1,-1]
	//[0,5,4,6,8,-1,-1,-1,-1].setMark(0,2) -> nuclear brocoli
	//[-1,-1,-1,-1,-1,-1,-1,-1,-1].setMark(0,3) -> nuclear brocoli
	@Override
	public void setMark(int row, int column) 
	{
		assert row >= 0 && row < ROW_COUNT : "row must be greater or equal to 0 "
				+ "and row must be less than or equal " + ROW_COUNT;
		assert column >= 0 && column < COLUMN_COUNT : "column must be greater or equal to 0 "
				+ "and row must be less than or equal " + COLUMN_COUNT;
		assert getMark(row, column) == null : "the cell has already been taken";
		assert !isGameOver() : " Game must not be over!";

		int cell = TicTacToeBoardImpl_Dalton.identifyCell(row, column);
		for(int i= 0; i < movesArray.length; i++)
		{
			if(movesArray[i] == -1)
			{
				movesArray[i] = cell; 
				break;

			}
		}
	}
	//pre: nothing
	//part of post: rv == null <==> it is neither player's turn (i.e.
	// game is over)
	//part of post: “number of Marks on board is even”è rv == Mark.X
	//part of post: “number of Marks on board is odd” è rv == Mark.O
	//Straightforward : [1,3,4,-1,-1,-1,-1,-1,-1].getTurn() -> Mark.O
	//Extreme : [-1,-1,-1,-1,-1,-1,-1,-1,-1].getTurn() -> Mark.X
	//Bizzare : [0,1,2,3,4,5,6,7,8].getTurn() -> null
	@Override
	public Mark getTurn() 
	{

		int countNumberOfMarks = 0;
		Mark whosTurn = null;
		for(int i= 0; i < movesArray.length; i++)
		{
			if(movesArray[i] != -1)
			{
				countNumberOfMarks++;

			}
		}
		if(isGameOver()== false)
		{
			if(countNumberOfMarks%2 == 0)
			{
				whosTurn = Mark.X;
			}
			if(countNumberOfMarks%2 == 1)
			{
				whosTurn = Mark.O;
			}
		}
		return whosTurn;
	}
	//pre: nothing
	//post returns an ArrayList of ArrayList<Integer> of ways to win tic tac toe 
	private static ArrayList<ArrayList<Integer> > listWaysToWins()
	{
		int n = 9;
		ArrayList<ArrayList<Integer> > listWaysToWins =  
				new ArrayList<ArrayList<Integer> >(n); 
		ArrayList<Integer> list_0_4_8 = new ArrayList(Arrays.asList(new Integer [] {0,4,8}));
		listWaysToWins.add(list_0_4_8);
		ArrayList<Integer> list_2_4_6 = new ArrayList(Arrays.asList(new Integer [] {2,4,6}));
		listWaysToWins.add(list_2_4_6);
		ArrayList<Integer> list_1_4_7 = new ArrayList(Arrays.asList(new Integer [] {1,4,7}));
		listWaysToWins.add(list_1_4_7);
		ArrayList<Integer> list_0_3_6 = new ArrayList(Arrays.asList(new Integer [] {0,3,6}));
		listWaysToWins.add(list_0_3_6);
		ArrayList<Integer> list_2_5_8 = new ArrayList(Arrays.asList(new Integer [] {2,5,8}));
		listWaysToWins.add(list_2_5_8);
		ArrayList<Integer> list_0_1_2 = new ArrayList(Arrays.asList(new Integer [] {0,1,2}));
		listWaysToWins.add(list_0_1_2);
		ArrayList<Integer> list_3_4_5 = new ArrayList(Arrays.asList(new Integer [] {3,4,5}));
		listWaysToWins.add(list_3_4_5);
		ArrayList<Integer> list_6_7_8 = new ArrayList(Arrays.asList(new Integer [] {6,7,8}));
		listWaysToWins.add(list_6_7_8);
		return listWaysToWins;

	}
	//pre: nothing
	//post: return value will equal true only if the array2 has all the elements in array1
	//Straightforward : containsSome([2,5,8], [2,1,7]) -> false
	//Extreme : containsSome([2,5,8], [1,2,3,5,8]) -> true
	//Bizzare : containsSome([],[]) -> false
	private static boolean containsSome(ArrayList<Integer> array1, ArrayList<Integer> array2)
	{
		int count = 0;
		for(int i = 0; i <array1.size();i++)
		{
			for(int j = 0; j <array2.size(); j++)
			{
				int indexOfArray1 = array1.get(i);
				int indexOfArray2 = array2.get(j);
				if(array1.get(i)==array2.get(j))
				{
					count++;
				}
			}
		}
		boolean rv = count == 3;
		return rv;
	}
	//pre: nothing
	//post:true if [movesArray[0], movesArray[2],movesArray[4],
	//movesArray[6],movesArray[8]].containsSome(listWaysToWins.get(i))
	// || [movesArray[1], movesArray[3],movesArray[5],movesArray[7]].containsSome(listWaysToWins.get(i))
	//Straightforward : [2,1,5,6,8,-1,-1,-1,-1].isGameOver() -> true
	//Extreme : [1,2,-1,-1,-1,-1,-1,-1,-1].isGameOver() -> false
	//Bizzare : [-1,-1,-1,-1,-1,-1,-1,-1,-1].isGameOver() -> false
	@Override
	public boolean isGameOver() 
	{
		boolean gameover = false;

		ArrayList<Integer> x_array = new ArrayList(Arrays.asList(new Integer [] {movesArray[0], movesArray[2],movesArray[4],movesArray[6],movesArray[8]}));
		ArrayList<Integer> o_array = new ArrayList(Arrays.asList(new Integer [] {movesArray[1], movesArray[3],movesArray[5],movesArray[7]}));
		ArrayList<ArrayList<Integer>> listWaysToWins = TicTacToeBoardImpl_Dalton.listWaysToWins();
		for(int i = 0; i <listWaysToWins.size(); i++)
		{
			ArrayList<Integer> aWayToWin = listWaysToWins.get(i);
			if(TicTacToeBoardImpl_Dalton.containsSome(listWaysToWins.get(i),x_array))
			{
				gameover = true;
				break;
			}
			if(TicTacToeBoardImpl_Dalton.containsSome(listWaysToWins.get(i),o_array))
			{
				gameover = true;
				break;
			}

		}
		boolean containsNegativeOne = false;
		for(int i = 0; i < movesArray.length;i++)
		{
			if(movesArray[i] == -1)
			{
				containsNegativeOne = true;
				break;
			}
		}
		if(containsNegativeOne== false)
		{
			gameover= true;
		}
		return gameover;
	}
	//part of pre: isGameOver()
	//part of post: rv == null <==> neither player won (i.e. the game
	// ended in a tie)
	//part of post: rv = Mark.X <==> [movesArray[0], movesArray[2],movesArray[4],
	//movesArray[6],movesArray[8]].containsSome(listWaysToWins.get(i))
	//part of post: rv = Mark.O <==> [movesArray[1], movesArray[3],movesArray[5],
	//movesArray[7]].containsSome(listWaysToWins.get(i))
	//Straightforward : [1,2,4,5,7,8,-1,-1,-1].getWinner() -> Mark.O
	//Extreme : [1,0,8,2,6,7,4,3,5].getWinner() -> null
	//Bizzare: [-1,-1,-1,-1,-1,-1,-1,-1,-1].getWinner() -> nuclear brocoli
	@Override
	public Mark getWinner() 
	{
		assert isGameOver() : "Game has to be over!";
		Mark winner =  null;
		ArrayList<Integer> x_array = new ArrayList(Arrays.asList(new Integer [] {movesArray[0], movesArray[2],movesArray[4],movesArray[6],movesArray[8]}));
		ArrayList<Integer> o_array = new ArrayList(Arrays.asList(new Integer [] {movesArray[1], movesArray[3],movesArray[5],movesArray[7]}));
		ArrayList<ArrayList<Integer>> listWaysToWins = TicTacToeBoardImpl_Dalton.listWaysToWins();
		for(int i = 0; i <listWaysToWins.size(); i++)
		{

			if(TicTacToeBoardImpl_Dalton.containsSome(listWaysToWins.get(i),x_array))
			{
				winner = Mark.X;
				break;
			}
			if(TicTacToeBoardImpl_Dalton.containsSome(listWaysToWins.get(i),o_array))
			{
				winner = Mark.O;
				break;
			}

		}
		return winner;
	}
	public String toString()
	{
		String tictactoestring = "";
		for(int i = 0; i< movesArray.length;i++)
		{
			if(i<movesArray.length-1)
			{
				tictactoestring += movesArray[i]+", ";
			}
			else
			{
				tictactoestring += movesArray[i];
			}
		}
		return tictactoestring;
	}
}

