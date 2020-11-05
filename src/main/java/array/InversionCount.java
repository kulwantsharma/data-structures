package array;

//https://www.geeksforgeeks.org/counting-inversions/
public class InversionCount
{
  static int count = 0;

  public static void main(String[] args)
  {

//    int arr[] = {8, 9, 10, 3, 5, 4, 1, 2, 6, 7};
//    int arr[] = {8, 4, 2, 1};
    int arr[] = {3, 1, 2};

    System.out
      .println("Inversion Count::" + countInversionUsingSelectionSort(arr));


    System.out.println("Inversion Count::" + countInversionUsingMergeSort(arr));


  }

  private static int countInversionUsingMergeSort(int[] arr)
  {
    count = 0;
    doMergeSort(arr, 0, arr.length - 1);

    return count;
  }

  private static void doMergeSort(int[] arr, int low, int high)
  {
    if (high > low)
    {
      int mid = low + (high - low) / 2;
      doMergeSort(arr, low, mid);
      doMergeSort(arr, mid + 1, high);
      merge(arr, low, mid, mid + 1, high);
    }
  }

  private static void merge(int[] arr, int low1, int high1, int low2, int high2)
  {
    int i = low1;
    int j = low2;
    int k = 0;
    int[] temp = new int[high2 - low1 + 1];

    while (i <= high1 && j <= high2)
    {
      if (arr[i] <= arr[j])
      {
        temp[k++] = arr[i++];
      }
      else
      {
        temp[k++] = arr[j++];
        count = count + high1 - i + 1;
      }
    }

    if (i > high1)
    {
      while (j <= high2)
      {
        temp[k++] = arr[j++];
      }
    }
    if (j > high2)
    {
      while (i <= high1)
      {
        temp[k++] = arr[i++];
      }
    }

    for (i = 0; i < k; i++)
    {
      arr[low1++] = temp[i];
    }

  }


  private static int countInversionUsingSelectionSort(int[] arr)
  {
    int count = 0;

    for (int i = 0; i < arr.length; i++)
    {
      for (int j = i + 1; j < arr.length; j++)
      {
        if (arr[i] > arr[j])
        {
          count++;
        }
      }
    }
    return count;
  }
}
