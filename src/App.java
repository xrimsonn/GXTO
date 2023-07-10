import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class App {
  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  static boolean gameOver = false;
  static String choice;
  static Random random = new Random();
  static int randRow, randCol;
  static String boardUI;
  public static void main(String[] args) throws Exception {
    //Start "screen"
    System.out.println("---TicTacToe---");
    String emptyBoard = 
      "# a b c"+"\n"+
      "1 "+" "+"|"+" "+"|"+" "+"\n"+
      "2 "+" "+"|"+" "+"|"+" "+"\n"+
      "3 "+" "+"|"+" "+"|"+" ";
    System.out.println(emptyBoard);

    //Game starting
    boardEngine();
  }

  public static void boardEngine(){
    String[] row1 = {" "," "," "};
    String[] row2 = {" "," "," "};;
    String[] row3 = {" "," "," "};;

    String[][] board = {row1,row2,row3};
    do {
      //Board string to print
      boardUI = 
      "# a b c"+"\n"+
      "1 "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]+"\n"+
      "2 "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]+"\n"+
      "3 "+board[2][0]+"|"+board[2][1]+"|"+board[2][2];
      
      //User input
      System.out.println("Choose a coordinate");
      try {
        choice = input.readLine().toLowerCase();
      } catch (IOException e) {
        System.out.println("error: not a valid input");
      }
      System.out.println("");
      
      //User placing "X"
      if (choice.contains("1")) {
        board[0][0] = (board[0][0].equals(" ") && choice.length() == 2 && choice.contains("a"))?"X":board[0][0];
        board[0][1] = (board[0][1].equals(" ") && choice.length() == 2 && choice.contains("b"))?"X":board[0][1];
        board[0][2] = (board[0][2].equals(" ") && choice.length() == 2 && choice.contains("c"))?"X":board[0][2];
      }

      if (choice.contains("2")) {
        board[1][0] = (board[1][0].equals(" ") && choice.length() == 2 && choice.contains("a"))?"X":board[1][0];
        board[1][1] = (board[1][1].equals(" ") && choice.length() == 2 && choice.contains("b"))?"X":board[1][1];
        board[1][2] = (board[1][2].equals(" ") && choice.length() == 2 && choice.contains("c"))?"X":board[1][2];
      }

      if (choice.contains("3")) {
        board[2][0] = (board[2][0].equals(" ") && choice.length() == 2 && choice.contains("a"))?"X":board[2][0];
        board[2][1] = (board[2][1].equals(" ") && choice.length() == 2 && choice.contains("b"))?"X":board[2][1];
        board[2][2] = (board[2][2].equals(" ") && choice.length() == 2 && choice.contains("c"))?"X":board[2][2];
      }
      if (gameOverCheck(board)){
        System.out.println("# a b c"+"\n"+
        "1 "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]+"\n"+
        "2 "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]+"\n"+
        "3 "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
        System.out.println("Game over, X wins!");
        break;
      }

      //Computer choosing a random and empty square to put "O"
      randCol = random.nextInt(0,3);
      randRow = random.nextInt(0,3);
      while (!board[randRow][randCol].equals(" ")){
        randCol = random.nextInt(0,3);
        randRow = random.nextInt(0,3);
      }
      board[randRow][randCol] = "O";

      if (gameOverCheck(board)){
        System.out.println("# a b c"+"\n"+
        "1 "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]+"\n"+
        "2 "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]+"\n"+
        "3 "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
        System.out.println("Game over, O wins!");
        break;
      }

      //Update the board
      boardUI = 
      "# a b c"+"\n"+
      "1 "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]+"\n"+
      "2 "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]+"\n"+
      "3 "+board[2][0]+"|"+board[2][1]+"|"+board[2][2];

      //Show the board
      System.out.println(boardUI);

    } while (!gameOver);
  }

  public static boolean gameOverCheck(String[][] board){

    //Checking the rows
    for (int i = 0; i < 3; i++) {
      if (board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]) && !board[i][0].equals(" "))
        return true;
    }

    //Checking the columns
    for (int i = 0; i < 3; i++) {
      if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(" "))
        return true;
    }

    //Checking diagonally
    if (board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]) && !board[0][0].equals(" "))
      return true;
    else if (board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0]) && !board[0][2].equals(" "))
      return true;

    return false;
  }
}
