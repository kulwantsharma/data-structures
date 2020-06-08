package main.java.array;

public final class TwoNonRepeatingElementsInArray {

    public static void main(String[] args) {

        int arr[] = {2, 7, 7, 9, 11, 2, 3, 11};

        printNonRepeatingElement(arr);
    }

    private static void printNonRepeatingElement(int[] arr) {

        int XOR = 0;
        for (int value : arr) {
            XOR ^= value;
        }

        int rightMostSetBit = XOR & -XOR;

        // Alternate..
//        while ((XOR & rightMostSetBit) == 0) {
//            rightMostSetBit *= 2;
//        }


        System.out.println("rightMostSetBit::" + rightMostSetBit);

        int nonRepeatElement1 = 0;
        int nonRepeatElement2 = 0;

        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] & rightMostSetBit) == 0) {
                nonRepeatElement1 ^= arr[i];
            } else {
                nonRepeatElement2 ^= arr[i];
            }

        }

        System.out.println("First Non Repeat Element:" + nonRepeatElement1);
        System.out.println("Second Non Repeat Element:" + nonRepeatElement2);

    }
}
