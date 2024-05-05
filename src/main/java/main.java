import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        helperFunction();
    }

    public static void helperFunction(){
        System.out.println("Please enter a value greater than equal to 3 for board size");
        Scanner in = new Scanner(System.in);
        int n = 0;
        try{
            n=in.nextInt();
        }catch (InputMismatchException e){
            helperFunction();
            return;
        }
        if(n<3){
            helperFunction();
            return;
        }
        System.out.println("Please enter the Player One name");
        String p1 = in.next();
        System.out.println("Please enter the Player Two name");
        String p2 = in.next();
        Player playerOne = new Player(p1, new PlayerPlayingPieceO());
        Player playerTwo = new Player(p2, new PlayerPlayingPieceX());
        TicTacToeGame ticTacToeGame = new TicTacToeGame(3,playerOne, playerTwo);
        ticTacToeGame.startTheGame();
    }
}
