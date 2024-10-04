public class Move {
    private Block startBlock;
    private Block endBlock;
    public Move(Block startBlock, Block endBlock){
        this.endBlock= endBlock;
        this.startBlock = startBlock;
    }
    public boolean isValid(){
            return !(startBlock.getPiece().isWhite() == endBlock.getPiece().isWhite());
    }
    public Block getStartBlock() {
        return startBlock;
    }
    public Block getEndBlock() {
        return endBlock;
    }
}