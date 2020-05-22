package main.java.array;

public class MedianInStreamOfIntergers {
    public static void main(String[] args) {

        int[] arr = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};

        printMedianUsingInsertionSort(arr);
//        for (int a : arr) {
//            System.out.print(a + " ");
//        }

    }

    private static void printMedianUsingInsertionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }

            if (i % 2 == 0){
                System.out.println(arr[i/2]);
            }else{
                System.out.println((arr[i/2] + arr[i/2 + 1])/2);
            }

        }

    }
}
