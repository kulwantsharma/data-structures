package array;

//https://www.geeksforgeeks.org/maximum-sum-path-in-a-matrix/
public class MaximumSumPathInMatrix
{
  static int maxSum = Integer.MIN_VALUE;

  public static void main(String[] args)
  {
    int[][] arr = {{5, 6, 1, 7},
      {-2, 10, 8, -1},
      {3, -7, -9, 11},
      {12, -4, 2, 6}};

//    int arr[][] = {{100, -350, -200},
//      {-100, -300, 700}};
//
//    int arr[][] = {{500, 100, 230},
//      {1000, 300, 100},
//      {200, 1000, 200}};

    int row = arr.length;
    int column = arr[0].length;
//    findMaximumSumPath(arr, row, column);

//    for (int i = 0; i < row; i++)
//    {
//      for (int j = 0; j < column; j++)
//      {
//        System.out.print(arr[i][j] + " ");
//      }
//      System.out.println();
//    }

    getMaxSumInPath(arr, 0, 0, 0, row, column);
    System.out.println("MaxSum:" + maxSum);

  }

  private static void findMaximumSumPath(int[][] arr, int row, int column)
  {
    for (int i = 0; i < row; i++)
    {
      for (int j = 0; j < column; j++)
      {
        arr[i][j] = Math
          .max(arr[i][j] + getElement(arr, i, j - 1, row, column),
            Math.max(arr[i][j] + getElement(arr, i - 1, j - 1, row, column),
              arr[i][j] + getElement(arr, i - 1, j, row, column)));

      }
    }

  }

  private static int getElement(int[][] arr, int i, int j, int row,
                                int column)
  {
    if (i >= 0 && i < row && j >= 0 && j < column) { return arr[i][j]; }

    return 0;
  }


  private static void getMaxSumInPath(int[][] arr, int i, int j, int sum, int row, int column)
  {
    if (i == row - 1 && j == column - 1)
    {
      if (maxSum < sum + arr[i][j])
      {
        maxSum = sum + arr[i][j];
      }
      return;
    }

    if (i < 0 || i >= row || j < 0 || j >= column) { return; }

    getMaxSumInPath(arr, i + 1, j, sum + arr[i][j], row, column);
    getMaxSumInPath(arr, i + 1, j + 1, sum + arr[i][j], row, column);
    getMaxSumInPath(arr, i, j + 1, sum + arr[i][j], row, column);

  }

}
