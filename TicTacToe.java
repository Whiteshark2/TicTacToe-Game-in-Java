package tic_tac_toeGame;

import java.util.Scanner;

public class TicTacToe {
	private Player player1,player2;
	private Board board;
	
	
	public static void main(String args[]) {
		TicTacToe t=new TicTacToe();
		t.startGame();
	}
	
	
	public void startGame() {
		Scanner sc=new Scanner(System.in);
		player1=takeInput(1);
		player2=takeInput(2);
		while(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("Symbol Already taken!! Pick another symbol!");
			char ch=sc.next().charAt(0);
			player2.setSymbol(ch);
		}
		board=new Board(player1.getSymbol(),player2.getSymbol());
		
		boolean player1Turn=true;
		int status=Board.Incomplete;
		while(status==Board.Incomplete || status==Board.Invalid) {
			if(player1Turn) {
				System.out.println("Player1 - "+player1.getName()+"'s turn");
				System.out.println("Enter x : ");
				int x=sc.nextInt();
				System.out.println("Enter y : ");
				int y=sc.nextInt();
				status=board.move(player1.getSymbol(),x,y);
				if(status!=Board.Invalid) {
					player1Turn=false;
					board.print();
				}else {
					System.out.println("Invalid Movie , Try Again!");
				}
			}
			else {
				System.out.println("Player2 - "+player2.getName()+"'s turn");
				System.out.println("Enter x : ");
				int x=sc.nextInt();
				System.out.println("Enter y : ");
				int y=sc.nextInt();
				status=board.move(player2.getSymbol(),x,y);
				if(status!=Board.Invalid) {
					player1Turn=true;
					board.print();
				}else {
					System.out.println("Invalid Movie , Try Again!");
				}
				
			}
		}
		if(status==Board.Player_1_wins) {
			System.out.println("Player 1 "+player1.getName()+" won!");
		}else if(status==Board.Player_2_wins) {
			System.out.println("Player 2 "+player2.getName()+" won!");
		}else {
			System.out.println("Game Drawn");
		}
		
	}
	private Player takeInput(int num) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter player"+num+" name : ");
		String s=sc.nextLine();
		System.out.println("Enter player"+num+" symbol: ");
		char ch=sc.next().charAt(0);
		Player p=new Player(s,ch);
		return p;
	}
	
	
}
