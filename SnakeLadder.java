import java.util.*;

public class SnakeLadder{

	public static void main(String[] args){
		System.out.println("Welcome to the Snakes and Ladders Game");

		Player p1 = new Player(1);
		Player p2 = new Player(2);
		
		int numDiceThrows = 0;
		while(p1.currPos < 100 && p2.currPos<100){
			p1.playGame();
			p2.playGame();
			numDiceThrows++;
		}
		if(p1.currPos == 100){
			System.out.println("Player 1 won !!");
		}
		else {
			System.out.println("Player 2 won !!");
		}
		System.out.println("Total number of times dice was thrown : " + numDiceThrows);
		
	}

}
class Player{
	int currPos = 0;
	int p;
	Player(int p){
		this.p = p;
	}
	public int diceThrow(){
		int diceNum = (int) (Math.floor(Math.random()*10) % 6)+1;
		return diceNum;
	}
	public int playersMove(int diceNum,int option){

		int checkPossibility = (int) Math.floor(Math.random()*10)%3 +1;
		switch(checkPossibility){
			case 1:
				this.currPos += diceNum;
				option=1;
				System.out.println("Player "+this.p+" got Ladder");
				if(this.currPos > 100){
					this.currPos -= diceNum;
				}
				else if(this.currPos == 100){
					option=0;
					break;
				}
				break;
			case 2:
				this.currPos -= diceNum;
				System.out.println("Player "+this.p+" got Snake");
				option = 2;
				if(this.currPos < 0) this.currPos = 0;
				break;

			default:
				option=3;
				System.out.println("Player "+this.p+" got No move");
		}
		return option;
	}
//	option - 1 for ladder, 2 for snake, 3 for no move, 0 for win
	public void playGame(){
			int diceNum = diceThrow();
			int option = 1;
			option = playersMove(diceNum,option);
			System.out.println("Player "+this.p+" at : " + this.currPos);
			if(option == 1){
				playGame();
			}
	}
}