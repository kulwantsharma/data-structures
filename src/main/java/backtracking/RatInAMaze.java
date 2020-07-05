package main.java.backtracking;

public final class RatInAMaze {

    static int[] down = {1, 0};
    static int[] forward = {0, 1};

    public static void main(String[] args) {

        int maze[][] = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        int[][] output = new int[4][4];
        output[0][0] = 1;

        solveMaze(maze, 0, 0, output);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static boolean solveMaze(int[][] maze, int i, int j, int[][] output) {

        if (i == 3 && j == 3) {
            return true;
        }
        for (int k = 0; k < 2; k++) {
            int ii = down[k] + i;
            int jj = forward[k] + j;
            if (isSafe(maze, ii, jj)) {
                output[ii][jj] = 1;
                if (solveMaze(maze, ii, jj, output)) {
                    return true;
                } else {
                    output[ii][jj] = 0;
                }
            }

        }
        return true;
    }

    private static boolean isSafe(int[][] maze, int i, int j) {
        if (i < 0 || i > 3 || j < 0 || j > 3 || maze[i][j] == 0) {
            return false;
        }
        return true;
    }
}
