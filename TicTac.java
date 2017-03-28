import java.util.Scanner;
public class TicTac{
  private static  char [][] board = new char [3][3];
  private static char playerX = 'X';
  private static char playerO = 'O';
  private static  Scanner keyboard = new Scanner(System.in);
  private static boolean playerTurn = true;
  private static int row1;
  private static int col1;
  private static boolean player = true ;

    public static void main(String[]   args){
      running();
  }
  public static void running(){
    menu();
    showBoard();
    clearBoard();
    currentPlayer();
    gameEnd();
  }

public static void menu(){
System.out.println("welcome to TIC TAC TOE ");
System.out.println("choose between row 1-3");
System.out.println("choose between coloum 1-3");
System.out.println("Enter 4 or any higher number twice to exit program");

  }

// rita upp brädet
public static void showBoard(){
  for(int i = 0; i < board.length; i++) {
    for(int j = 0; j < board[i].length; j++) {
      System.out.print( "[ " + board[i][j] + " ]" + "\t");
    }
    System.out.println("\n");
    }
  }
  //ta bort allt värde i arry / starta om spelet
public static void clearBoard(){
  for(int i = 0; i < board.length; i++) {
    for(int j = 0; j < board[i].length; j++) {
       board[i][j] = ' ';
     }
  }
}
public static void currentPlayer(){
  char maker;

    for (int turn = 0; turn < 9; turn++ ){

      if(playerTurn){
      playerWithO();
      maker = 'O';
        playerTurn = false;
        }else{
        playerWithX();
        maker = 'X';
          playerTurn = true;
      }
    if (cheakwinner(maker)){
      break;
    }else if(cheakwinner(maker) == false && turn == 8){
        System.out.println("DRAW");

      }
  }
    //System.out.println("DRAW");
  gameEnd();
}
public static void playerWithO(){

while(true){
  System.out.println(" Player O :Enter a row 1-3: ");
  row1 = keyboard.nextInt()-1;

  System.out.println(" Player O :Enter a column 1-3: ");
  col1 = keyboard.nextInt()-1;

  if(board[row1][col1] == ' '){
      board[row1][col1] = playerO;
      showBoard();
      break;

}else{
  System.out.println("Taken! Pick antoher  ");
    }
  }
}


public static void playerWithX(){

  while(true){
  System.out.println("Player X: Enter a row 1-3: ");
  row1 = keyboard.nextInt()-1;

  System.out.println("Player X:Enter a column 1-3: ");
    col1 = keyboard.nextInt()-1;

  if(board[row1][col1] == ' '){
      board[row1][col1] = playerX;
      showBoard();
      break;

}else{
  System.out.println("Taken! Pick antoher ");
    }
  }
}

public static boolean cheakwinner(char maker){
  boolean isThereAwinner = false;
    if (board[0][0] == maker && board[0][1] == maker && board[0][2] == maker || /* första raden*/
        board[1][0] == maker && board[1][1] == maker && board[1][2] == maker || /* andra raden*/
        board[2][0] == maker && board[2][1] == maker && board[2][2] == maker || /* tredje raden*/
        board[0][0] == maker && board[1][0] == maker && board[2][0] == maker || /*  första colum*/
        board[0][1] == maker && board[1][1] == maker && board[2][1] == maker || /* andra colum*/
        board[0][2] == maker && board[1][2] == maker && board[2][2] == maker || /* tredje colum*/
        board[0][0] == maker && board[1][1] == maker && board[2][2] == maker || /* snea vänster till höger*/
        board[2][0] == maker && board[1][1] == maker && board[0][2] == maker){ /*snea höger till vänster*/
          System.out.println( "player"+ maker + " has won");
          isThereAwinner = true;
          gameEnd();

      }
      return isThereAwinner;
    }
public static void gameEnd (){
  System.out.println("Wanna play again? type yes to continue");
  String answer ="yes";
  answer = keyboard.nextLine();
  while(answer.equals("yes")){
    clearBoard();
    System.out.println("New game");
    running();
    }
  }
}
