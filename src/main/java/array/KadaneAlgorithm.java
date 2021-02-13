package array;

public class KadaneAlgorithm {
    public static void main(String[] args) {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int max_so_far = arr[0];
        int current_max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            current_max = Math.max(arr[i], current_max + arr[i]);
            max_so_far = Math.max(max_so_far, current_max);

            System.out.println(max_so_far + " " + current_max);

        }


        System.out.println("Max Sub Array Sum:" + max_so_far);
    }
}
