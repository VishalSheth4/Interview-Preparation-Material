import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int freshOranges = 0;
        int time = 0;

        Queue<int[]> queue = new LinkedList<>();

        // Enqueue all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2)
                    queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1)
                    freshOranges++;
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshOranges--;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            time++;
        }
        return freshOranges == 0 ? time : -1;
    }

    public static void main(String[] args) {
        Main ro = new Main();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println("Minimum time required to rot all oranges: " + ro.orangesRotting(grid)); // Output: 4
    }
}
