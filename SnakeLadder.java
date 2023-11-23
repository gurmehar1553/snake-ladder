import java.util.*;

public class SnakeLadder{
	public static int currPos = 0;

	public static void playersMove(int diceNum){

		int checkPossibility = (int)Math.floor(Math.random()*10)%2 +1;
		switch(checkPossibility){
			case 1:
				currPos += diceNum;
				System.out.println("Ladder");
				break;
			case 2:
				currPos -= diceNum;
				System.out.println("Snake");
				if(currPos < 0) currPos = 0;
				break;
			default:
				System.out.println("No move");
		}
	}	

	public static void main(String[] args){
		System.out.println("Welcome to the Snakes and Ladders Game");
		int START_POS = 0;
		
		int numDiceThrows = 0;
		while(currPos < 100){
			int diceNum = (int) (Math.ceil(Math.random()*10) % 6)+1;
			numDiceThrows++;
			playersMove(diceNum);
			if(currPos > 100){
				currPos -= diceNum;
			}
			System.out.println("Player at : " + currPos);
		}
		System.out.println("Total number of times dice was thrown : " + numDiceThrows);
		System.out.println("Player won!!");
	}

}