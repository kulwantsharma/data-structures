package array;

//https://www.geeksforgeeks.org/maximum-path-sum-starting-cell-0-th-row-ending-cell-n-1-th-row/
public class MaximumSumPath
{
  static int maxSumPath = 0;

  public static void main(String[] args)
  {
    int[][] arr = {{4, 2, 3, 4},
      {2, 9, 1, 10},
      {15, 1, 3, 0},
      {16, 92, 41, 44}};

    int row = 4;
    int column = 4;

//    getMaxSumPath(arr, row, column);
//    System.out.println("MaxSum::" + maxSumPath);

    findMaximumSumPathUsingDP(arr, row, column);
    System.out.println("Printing matrix");
    for (int i = 0; i < row; i++)
    {
      for (int j = 0; j < column; j++)
      {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

  }

  private static void getMaxSumPath(int[][] arr, int row, int column)
  {
    for (int i = 0; i < column; i++)
    {
      getMaxSumPathUtil(arr, 0, i, row, column, 0);
    }
  }

  private static void getMaxSumPathUtil(int[][] arr, int i, int j, int row, int column, int sum)
  {

    if (i >= 0 && i < row && j >= 0 && j < column)
    {
      if (i == row - 1)
      {
        if (maxSumPath < sum + arr[i][j])
        {
          maxSumPath = sum + arr[i][j];
          return;
        }
      }

      getMaxSumPathUtil(arr, i + 1, j - 1, row, column, sum + arr[i][j]);
      getMaxSumPathUtil(arr, i + 1, j, row, column, sum + arr[i][j]);
      getMaxSumPathUtil(arr, i + 1, j + 1, row, column, sum + arr[i][j]);
    }

  }

  private static void findMaximumSumPathUsingDP(int[][] arr, int row, int column)
  {
    for (int i = 1; i < row; i++)
    {
      for (int j = 0; j < column; j++)
      {
        arr[i][j] = Math
          .max(arr[i][j] + getElement(arr, i - 1, j + 1, row, column),
            Math.max(arr[i][j] + getElement(arr, i - 1, j - 1, row, column),
              arr[i][j] + getElement(arr, i - 1, j, row, column)));

      }
    }
  }

  private static int getElement(int[][] arr, int i, int j, int row, int column)
  {
    if (i >= 0 && i < row && j >= 0 && j < column) { return arr[i][j]; }

    return 0;
  }
}
