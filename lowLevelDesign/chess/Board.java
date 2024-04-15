public class Board {
    private Block[][] blocks;
    public Board() {
        initializeBoard();
    }
    private void initializeBoard(){
        // Setting White Pieces
        blocks[0][0] = new Block(0,0,new Rook(true));
        blocks[0][1] = new Block(0,1,new Knight(true));
        blocks[0][2] = new Block(0,2,new Bishop(true));
        blocks[0][3] = new Block(0,3,new Queen(true));
        blocks[0][4] = new Block(0,4,new King(true));
        blocks[0][5] = new Block(0,5,new Bishop(true));
        blocks[0][6] = new Block(0,6,new Knight(true));
        blocks[0][7] = new Block(0,7,new Rook(true));
        for(int j=0; j<8 ; j++){
            blocks[1][j] = new Block(1,j,new Pawn(true));
        }
        //Setting Black Pieces
        blocks[7][0] = new Block(7,0,new Rook(false));
        blocks[7][1] = new Block(7,1,new Knight(false));
        blocks[7][2] = new Block(7,2,new Bishop(false));
        blocks[7][3] = new Block(7,3,new Queen(false));
        blocks[7][4] = new Block(7,4,new King(false));
        blocks[7][5] = new Block(7,5,new Bishop(false));
        blocks[7][6] = new Block(7,6,new Knight(false));
        blocks[7][7] = new Block(7,7,new Rook(false));
        for(int j=0; j<8 ; j++){
            blocks[6][j] = new Block(6,j,new Pawn(false));
        }
        // Defining rest of the blocks having no pieces
        for(int i=2;i<6;i++){
            for( int j=0; j<8; j++){
                blocks[i][j] = new Block(i,j,null);
            }
        }
    }
}