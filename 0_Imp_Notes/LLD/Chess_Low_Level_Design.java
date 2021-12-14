// Base Case
// Services

public class Chess{
    ChessBoard chessBoard;
    Player[] player;
    Player currentPlayer;
    List<Move> movesList;
    GameStatus gamestatus;

    public boolean playerMove(CellPosition fromPosition, CellPosition toPosition, Piece piece){
        // it call updateBoard(Move move);
    }
    public boolean endGame();
    private void changeTurn();
}

public class Player{
    Account account;
    Color color;
    Time timeLeft;
}

public class Account{
    String username;
    String password;
    String name;
    Stirng email
    String phone;
}

public enum Color{
    BLACK, WHITE;
}

public class Time{
    int mins;
    int secs;
}

public enum GameStatus{
    ACTIVE, PAUSED, FORTFEIGHT, BLACK_WIN, WHITE_WIN;
}

public class ChessBoard{
    List<List<Cell>> board;

    public void resetBoard;
    public void updateBoard(Move move);
}

public class Cell{
    Color color;
    Piece piece;
    CellPosition position;
}

public class CellPosition{
    Char ch;
    int i;
}

public class Move{
    Player turn;
    piece piece;
    piece killedPiece;
    CellPosition startPosition;
    CellPosition endPosition;
}

public abstract class Piece{
    Color color;
    public boolean move(CellPosition fromPosition, CellPosition toPosition);
    public List<CellPosition> possibleMoves(CellPosition  fromPosition, CellPosition toPosition);
    public boolean validate(CellPosition fromPosition, CellPosition toPosition);
}

public class King extends Piece{
    public boolean move(CellPosition fromPosition, CellPosition toPosition);
    public List<CellPosition> possibleMoves(CellPosition  fromPosition, CellPosition toPosition);
    public boolean validate(CellPosition fromPosition, CellPosition toPosition);
}

public class Queen extends Piece{
    public boolean move(CellPosition fromPosition, CellPosition toPosition);
    public List<CellPosition> possibleMoves(CellPosition  fromPosition, CellPosition toPosition);
    public boolean validate(CellPosition fromPosition, CellPosition toPosition);
}

public class Pawn extends Piece{
    public boolean move(CellPosition fromPosition, CellPosition toPosition);
    public List<CellPosition> possibleMoves(CellPosition  fromPosition, CellPosition toPosition);
    public boolean validate(CellPosition fromPosition, CellPosition toPosition);
}

public class Knight extends Piece{
    public boolean move(CellPosition fromPosition, CellPosition toPosition);
    public List<CellPosition> possibleMoves(CellPosition  fromPosition, CellPosition toPosition);
    public boolean validate(CellPosition fromPosition, CellPosition toPosition);
}

public class Bishop extends Piece{
    public boolean move(CellPosition fromPosition, CellPosition toPosition);
    public List<CellPosition> possibleMoves(CellPosition  fromPosition, CellPosition toPosition);
    public boolean validate(CellPosition fromPosition, CellPosition toPosition);
}

public class rook extends Piece{
    public boolean move(CellPosition fromPosition, CellPosition toPosition);
    public List<CellPosition> possibleMoves(CellPosition  fromPosition, CellPosition toPosition);
    public boolean validate(CellPosition fromPosition, CellPosition toPosition);
}


