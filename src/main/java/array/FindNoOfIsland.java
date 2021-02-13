package array;

//https://www.geeksforgeeks.org/find-number-of-islands/
public class FindNoOfIsland {

    static int jMoves[] = {-1, 0, +1, -1, 0, 1, -1, 1};
    static int iMoves[] = {-1, -1, -1, 1, 1, 1, 0, 0};

    public static void main(String[] args) {

        int mat[][] = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        System.out.println("No Of Island:" + countNoOfIsland(mat));
    }

    private static int countNoOfIsland(int[][] arr) {

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j] == 1 && !visited[i][j]) {
                    count++;
                    doDFS(i, j, arr, visited);
                }

            }
        }
        return count;
    }

    private static void doDFS(int i, int j, int[][] arr, boolean[][] visited) {

        visited[i][j] = true;

        for (int k = 0; k < iMoves.length; k++) {

            int ii = i + iMoves[k];
            int jj = j + jMoves[k];
            if (isSafe(ii, jj, arr, visited)) {
                doDFS(ii, jj, arr, visited);
            }

        }

    }

    private static boolean isSafe(int i, int j, int[][] arr, boolean[][] visited) {

        if (i >= 0 && i < arr.length && j >= 0 && j < arr[0].length && arr[i][j] == 1 && !visited[i][j]) {
            return true;
        }
        return false;
    }


}
