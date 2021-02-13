package array;

//https://www.geeksforgeeks.org/array-rotation/
public class ArrayRotation {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int x = 2;

//        performArrayRotationByX(arr, x);

        performArrayRotationByXUsingJugglingAlgo(arr, x);
        printArray(arr);
    }

    private static void performArrayRotationByXUsingJugglingAlgo(int[] arr, int x) {

        int gcd = findGCD(arr.length, x);

        for (int i = 0; i < gcd; i++) {

            int temp = arr[i];
            int j = i, k;
            while (true) {
                k = (j + x) % arr.length;
                if (k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }

            arr[j] = temp;

        }

    }

    private static int findGCD(int a, int b) {

        if (b % a == 0) {
            return a;
        } else return findGCD(b % a, a);

    }

    private static void performArrayRotationByX(int[] arr, int x) {

        for (int i = 0; i < x; i++) {

            int temp = arr[i];
            int j = i;
            for (; j < arr.length - x; j += x) {
                arr[j] = arr[j + x];
            }
            arr[j] = temp;
//            printArray(arr);
//            System.out.println();
        }

    }

    private static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
