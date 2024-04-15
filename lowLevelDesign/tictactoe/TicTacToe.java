public class TicTacToe{
	private final int[][] board;
	
	/* storing value so that it give winner in O(1) time.
	private final int[]=rowSum, colSum;
	private int diagSum, revDiagsum;
	*/
	
	public TicTacToe(final int n) {
		board = new int[n][n];
	}
	
/*	Makes a move on the board and returns the winner if the move is a winning move.
	@player  is either 0 or 1
	@row     move row index
	@col     move column index
	@winner  +1 if the first player, -1 second player and zero otherwise.
	@throws IllegalArgumentException - if the move is illegal move.
*/
	public int move(int player, int row, int col) throws IllegalArgumentException{
		if(row<0 || col <0 || row>=n || col >= n) {
			throw new IllegalArgumentException("Move out of board boundary..!");
		}else if(board[row][col]!=0) {
			throw new IllegalArgumentException("Square is already occupied..!");
		}else if(player !=0 && player !=1) {
			throw new IllegalArgumentException("Invalid player");
		}else {
			player = player == 0 ? -1 : +1;
			board[row][col] = player;
			boolean winRow = true, winCol = true, winDiag = true, winRevDiag = true;
			for(int i=0;i<n;i++) {
				if(board[row][i]!=player) {
					winRow = false;
				}
				if(board[i][col]!=player) {
					winCol = false;
				}
				if(board[i][i]!=player) {
					winDiag = false;
				}
				if(board[i][n-1-i]!=player) {
					winRevDiag = false;
				}
			}
			if(winRow || winCol || winDiag || winRevDiag) {
				return player;
			}
			return 0;
		}
	}
}