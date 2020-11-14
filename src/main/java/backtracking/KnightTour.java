package backtracking;


public class KnightTour {

    static Point[] moves = {new Point(-2, -1), new Point(-2, +1), new Point(-1, -2), new Point(-1, +2),
            new Point(+1, -2), new Point(+1, +2), new Point(+2, -1), new Point(+2, +1)};

    static int tourStep = 0;

    public static void main(String[] args) {

        int board[][] = new int[8][8];

        //print tour
        System.out.println("Before tour");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = -1;
            }
        }
        board[0][0] = 0;
        tour(board, 0, 0, 1);

        //print tour
        System.out.println("After tour");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static boolean tour(int[][] board, int i, int j, int tourStep) {

        if (tourStep == 64)
            return true;

        for (Point move : moves) {

            int ii = move.i + i;
            int jj = move.j + j;
            if (isSafe(board, ii, jj)) {
                board[ii][jj] = tourStep;
                if (tour(board, ii, jj, tourStep + 1)) {
                    return true;
                } else {
//                    System.out.println("backtracking..i:" + i + " j:" + j);
                    board[ii][jj] = -1;
                }
            }

        }
        return false;
    }

    private static boolean isSafe(int[][] board, int i, int j) {

        if (i < 0 || i > 7 || j < 0 || j > 7 || board[i][j] != -1) {
            return false;
        }

        return true;
    }

    static class Point {
        int i;
        int j;

        Point(int x, int y) {
            this.i = x;
            this.j = y;
        }
    }

}
