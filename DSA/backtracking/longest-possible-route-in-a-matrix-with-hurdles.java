import java.util.*;
public class Main {
    public static int xd = 1;
    public static int yd = 7;
    public static int mat[][] = { 
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
        };
    
    public static ArrayList<Pair> directions = new ArrayList<>();
    
    static class Pair{
        int first;
        int second;
    
        public Pair(int first, int second) {
        this.first = first;
        this.second = second;
        }
    }
    public static int calcPath(int xs, int ys, int currLength, int length){
        if(xs == xd && ys == yd){
            return Math.max(currLength, length);
        }

        mat[xs][ys] = 2;
        for(Pair dir : directions){
            int newX = xs + dir.first;
            int newY = ys + dir.second;
            if(newX >= 0 && newY >= 0 && newX < mat.length && newY < mat[0].length && mat[newX][newY] == 1){
                length = calcPath(newX, newY, currLength + 1, length);
            }
        }       
        mat[xs][ys]=1;
        return length;
    }
    
    public static int findLongestPath(int xs, int ys){
        if(mat[xs][ys] == 0 || mat[xd][yd] == 0){
            return -1;
        }
        int currLength = 0;
        int length = -1;
        return calcPath(xs, ys,currLength, length);
    }
	public static void main(String[] args) {
        System.out.println("Hello World");
        directions.add(new Pair(0, 1));
        directions.add(new Pair(0, -1));
        directions.add(new Pair(1, 0));
        directions.add(new Pair(-1, 0));
        
        System.out.println(findLongestPath(0, 0));
    }
}
