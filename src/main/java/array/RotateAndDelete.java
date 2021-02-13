package array;

//https://practice.geeksforgeeks.org/problems/rotate-and-delete/0
public final class RotateAndDelete {
    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {229, 467775, 9, 24715, 185, 8, 14469, 723436, 7231, 4352, 9, 86, 749573, 5, 8449, 9891, 79, 742619, 4, 1595, 2433, 668744, 4, 215824, 33643, 9, 799122, 565999, 1, 522135, 3, 47876, 23494, 669, 586865, 5628, 28355, 98, 9, 76, 13792, 578, 994, 191, 832, 2893, 7, 278, 2, 32, 7196, 187, 6488, 871596, 7, 5, 86986, 5, 483549, 91, 538, 322, 263618, 865, 117612, 746, 4, 92, 1336, 97775, 39967, 34823, 3916, 85288, 27863, 9, 6849, 22, 81923, 964723, 723488, 2, 1535, 84442, 113, 1};

////        rotate(arr, 6);
//        int size = 6;
//        int index = 6;
//
//        delete(arr, size, index);
//        printArray(arr, 5);

        rotateAndDelete(arr, arr.length);

        System.out.println(arr[0]);


    }

    private static void rotateAndDelete(int[] arr, int size) {
        int i = 0;
        while (size > 1) {

            rotate(arr, size);
            delete(arr, size, i);
            size--;
            i++;
        }
    }

    private static void delete(int[] arr, int size, int index) {

        boolean isDeleted = false;

        index = size - index - 1;

        if (index == size - 1) {
            isDeleted = true;
        } else {

            for (int i = index; i >= 0 && i < size - 1; i++) {
                isDeleted = true;
                arr[i] = arr[i + 1];
            }

        }

        if (!isDeleted) {
            for (int i = 0; i < size - 1; i++) {
                arr[i] = arr[i + 1];
            }
        }

        size--;
    }

    private static void printArray(int[] arr, int size) {

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    private static void rotate(int[] arr, int size) {

        int temp = arr[size - 1];

        for (int i = size - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

        arr[0] = temp;
    }
}
