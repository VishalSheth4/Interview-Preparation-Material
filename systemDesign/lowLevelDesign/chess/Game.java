import java.util.ArrayList;

public class Game {
    private Board board;
    // Assuming player1 is always WHITE
    private Player player1;
    // Assuming player2 is always BLACK
    private Player player2;
    boolean isWhiteTurn;
    private ArrayList<Move> gameLog;
    private Status status;
    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.isWhiteTurn = true;
        this.status = Status.ACTIVE;
        this.gameLog = new ArrayList<>();
    }

    public void start(){
        // Continue the game till the status is active
        while(this.status==Status.ACTIVE){
            // player1 will make the move if its white's turn
            // else player2 will make the move
            if(isWhiteTurn){
                //makeMove(new Move(startBlock,endBlock),player1);
            }
            else{
                //makeMove(new Move(startBlock,endBlock),player2);
            }
        }
    }

    public void makeMove(Move move, Player player){
        // Initial check for valid move
        // To check if source and destination doesn't contain
        // the same color pieces.
        if (move.isValid()){
            Piece sourcePiece = move.getStartBlock().getPiece();
            // Check if source piece can be moved or not
            if(sourcePiece.canMove(this.board,move.getStartBlock(),move.getEndBlock())){
                Piece destinationPiece = move.getEndBlock().getPiece();
                // check if destination block contains some peice
                if(destinationPiece != null ){
                    // if destination block contains King
                    // and currently white is playing --> White wins
                    if(destinationPiece instanceof King && isWhiteTurn){
                        this.status = Status.WHITE_WIN;
                        return;
                    }
                    // if destination block contains King
                    // and currently Black is playing --> Black wins
                    if(destinationPiece instanceof King && !isWhiteTurn){
                        this.status = Status.BLACK_WIN;
                        return;
                    }
                    // Set the destination piece as killed
                    destinationPiece.setKilled(true);
                }
                // Adding the valid move to game logs
                gameLog.add(move);
                // Moving the source piece to the destination block
                move.getEndBlock().setPiece(sourcePiece);
                // Setting the source block to null (means it doesn't have any piece)
                move.getStartBlock().setPiece(null);
                // Toggling the turn
                // If it is white Turn, next will be Black Turn
                // else if it is Black Turn, next will be White Turn
                isWhiteTurn = !isWhiteTurn;
            }
        }
    }
}
