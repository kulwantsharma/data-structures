package main.java.array;

//https://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
public final class TwoRepeatingNumber {
    public static void main(String[] args) {

        int[] arr = {4, 2, 4, 5, 2, 3, 1};

        printRepeatingElement(arr);

    }

    private static void printRepeatingElement(int[] arr) {

        int XOR = arr[0];

        for (int i = 1; i < arr.length; i++) {
            XOR ^= arr[i];
        }

        for (int i = 1; i <= arr.length - 2; i++) {
            XOR ^= i;
        }

        System.out.println("XOR:"+XOR);
        int rightMostSetBit = 1;
        while ((XOR & rightMostSetBit) == 0) {
            rightMostSetBit *= 2;
        }

        System.out.println("rightMostSetBit:" + rightMostSetBit);

        int nonRepeatElement1 = 0;
        int nonRepeatElement2 = 0;

        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] & rightMostSetBit) == 0) {
                nonRepeatElement1 ^= arr[i];
            } else {
                nonRepeatElement2 ^= arr[i];
            }

        }

        for (int i = 1; i <= arr.length - 2; i++) {
            if ((i & rightMostSetBit) == 0) {
                nonRepeatElement1 ^= i;
            } else {
                nonRepeatElement2 ^= i;
            }
        }


        System.out.println("First Repeating Element:" + nonRepeatElement1);
        System.out.println("Second Repeating Element:" + nonRepeatElement2);

    }
}
