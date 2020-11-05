package array;

//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
public class FindElementInSortedAndRotatedArray
{
  public static void main(String[] args)
  {
//    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//    int arr[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
//    int arr[] = {3, 4, 5, 6, 7, 8, 9, 10, 1, 2};
//    int arr[] = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
//    int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3, 4};
//    int arr[] = {7, 8, 9, 10, 1, 2, 3, 4, 5, 6};
//    int arr[] = {6, 7, 8, 9, 10, 1, 2, 3, 4, 5};
    int arr[] = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};

    for (int i = 0; i < arr.length; i++)
    {
      int key = arr[i];
      System.out
        .println("Element:" + key + " Index::" + findElement(arr, 0, arr.length - 1, key));
    }
  }

  private static int findElement(int[] arr, int low, int high, int key)
  {
    if (high >= low)
    {
      int mid = low + (high - low) / 2;

      if (arr[mid] == key) { return mid; }

      if (arr[low] <= arr[mid])
      {
        if (key >= arr[low] && key <= arr[mid])
        {
          return findElement(arr, low, mid - 1, key);
        }
        else
        {
          return findElement(arr, mid + 1, high, key);
        }
      }
      else
      {
        if (key >= arr[mid] && key <= arr[high])
        {
          return findElement(arr, mid + 1, high, key);
        }
        else
        {
          return findElement(arr, low, mid - 1, key);
        }

      }

    }
    return -1;
  }

//  private static int findElement(int[] arr, int low, int high, int key)
//  {
//    if (high >= low)
//    {
//      int mid = low + (high - low) / 2;
//
//      if (arr[mid] == key) { return mid; }
//
//      if (key < arr[mid])
//      {
//        if (key >= arr[low])
//        {
//          return findElement(arr, low, mid - 1, key);
//        }
//        else
//        {
//          return findElement(arr, mid + 1, high, key);
//        }
//      }
//      else
//      {
//        if (key <= arr[high])
//        {
//          return findElement(arr, mid + 1, high, key);
//        }
//        else
//        {
//          return findElement(arr, low, mid - 1, key);
//        }
//      }
//    }
//
//    return -1;
//  }
}
