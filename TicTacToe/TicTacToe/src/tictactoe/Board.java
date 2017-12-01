/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Tony
 */
public class Board {
    private String[][] gameBoard = new String[3][3];
    
//status of game
    private boolean gameOver = false;
    
//number of game turns played
    private int turns = 1;
    
    
    public Board(){
        //Defaults the matrix of inputs to empty spaces
        
        for(String[] rows: gameBoard)
            Arrays.fill(rows, "   ");
        runGame();
        
        
    }
    //Draws the gameboard
    private void drawBoard(String[][] board)    {
         board = gameBoard;
       
        for(int i = 0; i< 4; i++){
            System.out.println("+" + "---" + "+" + "---" + "+" + "---" + "+" );
            
            if(i < 3)
                System.out.println("+" + board[i][0] + "+" + board[i][1] + "+" + board[i][2] + "+" );
                    
        }
        
    }
    
    
  private void runGame()  {
  
      while(!gameOver)  {
          
          Scanner keyboard = new Scanner(System.in);
          String team;
          
          drawBoard(gameBoard);
          
          if (turns % 2 == 0)
          {
              System.out.println("Player 2's turn");
              team = "x";
          }else {
              System.out.println("Player 1's turn");
              team = "O";
      }
          
          
          
          System.out.println("Enter X coordinate: ");
          int xcoord = keyboard.nextInt();
          System.out.println("Enter Y coordinate: ");
          int ycoord = keyboard.nextInt();
          
          int check = gameLogic(xcoord, ycoord, team);
          
          if(check == 1)
              turns++;
          
          
          
              
          
          
      }
      
  }
  
  private int gameLogic(int xCord, int yCord, String team) {
      int xcoord = xCord - 1;
      int ycoord = yCord - 1;
      int result = 0;
      
     if((xcoord < 0) || (xcoord > 2) || (ycoord < 0) || (ycoord > 2))   {
          System.out.println("not a valid location. please try again");
      } else if(gameBoard[xcoord][ycoord].equals("   "))    {
          gameBoard[xcoord][ycoord] = " " + team + " ";
          result = 1;
      }
      else{
          System.out.println("not a valid location. please try again");
      }
      
      gameOverCheck(gameBoard);
      
      return result;
      
      
              
  }
  
  private void gameOverCheck(String[][] board)  {
      //Horizontal gameover check
      
      for(int i=0; i<3; i++)    
      {
          String test = "" + board[i][0] + board[i][1] + board[i][2];
          
          if(test.equals(" x  x  x "))  
          {
              System.out.println("Game over. Player 2 wins");
              drawBoard(gameBoard);
              gameOver = true;
          }
          
          if(test.equals(" O  O  O "))
          {
              System.out.println("Game over. Player 1 wins");
              drawBoard(gameBoard);
              gameOver = true;
          }
              
      }
      
      //Vertical game check
      
      for(int i=0; i<3; i++)
      {
          String test = "" + board[0][i] + board[1][i] + board[2][i];
          
          if(test.equals(" x  x  x "))
          {
              System.out.println("Game over. Player 2 wins");
              drawBoard(gameBoard);
              gameOver = true;
          }
          
          if(test.equals(" O  O  O "))
          {
              System.out.println("Game over. Player 1 wins");
              drawBoard(gameBoard);
              gameOver = true;
          }
      }
      
      //Diagonal game check
      
      String diag1 = "" +  board[0][0] + board[1][1] + board[2][2];
      String diag2 = "" + board[0][2] + board[1][1] + board[2][0];
      
      if(diag1.equals(" x  x  x "))
      {
          System.out.println("Game over. Player 2 wins");
          drawBoard(gameBoard);
          gameOver = true;
      }
      if(diag1.equals(" O  O  O "))
      {
          System.out.println("Game over. Player 1 wins");
          drawBoard(gameBoard);
          gameOver = true;
      }
      if(diag2.equals(" x  x  x "))
      {
          System.out.println("Game over. Player 2 wins");
          drawBoard(gameBoard);
          gameOver = true;
      }
      if(diag2.equals(" O  O  O "))
      {
          System.out.println("Game over. Player 1 wins");
          drawBoard(gameBoard);
          gameOver = true;
      }
      
      //Tie check
      
      if(turns == 9)
      {
          System.out.println("its a tie");
          drawBoard(gameBoard);
          gameOver = true;
      }
  }
  
  
          
    
    
}
//LEFT TO FINISH
//Logic to check if game is over
//Fix the coordinate system
//Expand
//AI??