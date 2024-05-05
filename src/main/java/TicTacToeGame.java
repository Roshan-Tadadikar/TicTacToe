import java.util.*;

public class TicTacToeGame {
    Board board;
    Player playerOne;
    Player playerTwo;
    Queue<Player> queue;

    public TicTacToeGame(int s, Player p1, Player p2){
        this.board = new Board(s);
        playerOne=p1;
        playerTwo=p2;
        queue = new LinkedList<>();
    }

    public void startTheGame(){
        queue.offer(playerOne);
        queue.offer(playerTwo);
        Scanner in = new Scanner(System.in);
        while (!board.winner && !board.tie){
            Player currentPlayer = queue.peek();
            System.out.println(currentPlayer.playerName+" Please enter your position");
            String val = in.next();
            if(board.addValue(val, currentPlayer.playerPiece.peiceType)){
                queue.poll();
                queue.offer(currentPlayer);
                board.Print();
            }
        }
        if(board.winner){
            queue.poll();
            System.out.println(queue.peek().playerName+" Is the winner !!");
        }
        else if(board.tie){
            System.out.println("Oops !! Its a tie!!");
        }
    }


}
