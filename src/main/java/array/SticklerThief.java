package array;

//https://practice.geeksforgeeks.org/problems/stickler-theif/0
//https://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
public class SticklerThief
{
  public static void main(String[] args)
  {

//    int arr[] = {3, 2, 7, 10, 15, 13};
//    int arr[] = {5, 5, 10, 100, 10, 5};
//    int arr[] = {1, 2, 3};
//    int arr[] = {1, 20, 3};
    int arr[] = {1};
//    int arr[] = {1, 20};

    System.out.println("Total Looted amount::" + maximumLootAmount(arr));

  }

  private static int maximumLootAmount(int[] arr)
  {
    int temp[] = new int[arr.length];

    if (arr.length == 1) { return arr[0]; }

    temp[0] = arr[0];
    temp[1] = arr[1];

    if (arr.length > 2)
    {
      temp[2] = arr[2] + arr[0];

      for (int i = 3; i < arr.length; i++)
      {
        temp[i] = arr[i] + Math.max(temp[i - 2], temp[i - 3]);
      }
    }
    return Math.max(temp[arr.length - 1], temp[arr.length - 2]);
  }
}
