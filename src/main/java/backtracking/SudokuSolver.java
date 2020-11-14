package backtracking;

//
public class SudokuSolver {
    public static void main(String[] args) {

        int[][] grid = {
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}


        };

       solveSudoku(grid, 0, 0);

        //print the solution
        System.out.println("Solved Sudoku");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static boolean solveSudoku(int[][] grid, int i, int j) {

        for (; i < 9; i++, j = 0) {
            for (; j < 9; j++) {

                if (grid[i][j] == 0) {

                    for (int k = 1; k <= 9; k++) {
                        if (checkIfSafeToAssign(grid, i, j, k)) {
                            grid[i][j] = k;
                            if (solveSudoku(grid, i, j)) {
                                return true;
                            }
                            grid[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean checkIfSafeToAssign(int[][] grid, int row, int column, int k) {


        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == k || grid[i][column] == k) {
                return false;
            }
        }

        return presentInSubGrid(grid,row,column,k);

//        return true;
    }

    private static boolean presentInSubGrid(int[][] grid, int i, int j, int k) {

        int r = 0, c = 0;

        if (i >= 0 && i <= 2) {

            if (j >= 0 && j <= 2) {
                r = 0;
                c = 0;
            } else if (j >= 3 && j <= 5) {
                r = 0;
                c = 3;
            } else {
                r = 0;
                c = 6;
            }

        } else if (i >= 3 && i <= 5) {

            if (j >= 0 && j <= 2) {
                r = 3;
                c = 0;
            } else if (j >= 3 && j <= 5) {
                r = 3;
                c = 3;
            } else {
                r = 3;
                c = 6;
            }
        } else if (i >= 6 && i <= 8) {
            if (j >= 0 && j <= 2) {
                r = 6;
                c = 0;
            } else if (j >= 3 && j <= 5) {
                r = 6;
                c = 3;
            } else {
                r = 6;
                c = 6;
            }
        }

        for (int p = r; p < r + 3; p++) {
            for (int q = c; q < c + 3; q++) {
                if (grid[p][q] == k) {
                    return false;
                }
            }
        }
        return true;
    }

}
