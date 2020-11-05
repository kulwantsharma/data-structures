package array;

//https://www.geeksforgeeks.org/find-bitonic-point-given-bitonic-sequence/
//https://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
public class BitonicPoint
{
  public static void main(String[] args)
  {
//    int[] arr = {8, 9, 10, 7, 6, 5, 4, 3, 2, 1};
//    int[] arr = {1, 2, 3, 4, 5, 6, 7, 10, 9, 8};
//    int arr[] = {6, 7, 8, 11, 9, 5, 2, 1};
//    int arr[] = {-3, -2, 4, 6, 10, 8, 7, 1};
//    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int arr[] = {10, 20, 30, 40, 50};

    int bitonicPoint = findBitonicPoint(arr, 0, arr.length - 1);

    if (bitonicPoint == -1)
    {
      bitonicPoint = Math.max(arr[0], arr[arr.length - 1]);
    }
    System.out.println("Bitonic Point::" + bitonicPoint);
  }

  private static int findBitonicPoint(int[] arr, int low, int high)
  {
    if (high >= low)
    {
      int mid = low + (high - low) / 2;

      if (mid - 1 >= 0 && mid + 1 < arr.length)
      {
        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1])
        {
          return arr[mid];
        }

        if (arr[mid] > arr[mid + 1])
        { return findBitonicPoint(arr, low, mid - 1); }
        else
        { return findBitonicPoint(arr, mid + 1, high); }

      }

    }
    return -1;
  }
}
