public class Block {
    private int x,y;
    private String label;
    private Piece piece;
    public Block(int x, int y, Piece piece) {
        this.x = x;
        this.y = y;
        this.label = assignLabel(x,y);
        this.piece = piece;
    }
    private  String assignLabel(int x, int y){
        String[] xLabels = {"1","2","3","4","5","6","7","8"};
        String[] yLabels = {"A","B","C","D","E","F","G","H"};
        return xLabels[x] + yLabels[y];
    }
    public Piece getPiece() {
        return piece;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}