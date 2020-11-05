package array;

//https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
public class NextGreaterNumber {
    public static void main(String[] args) {

//        String number = "218765";
        String number = "4321";
//        String number = "534976";

//        String number = "534321";

        System.out.println(printNextGreaterNumber(number.toCharArray()));

    }

    public static String printNextGreaterNumber(char[] number) {

        boolean flag = false;
        for (int i = number.length - 2; i >= 0; i--) {

            if (number[i] < number[i + 1]) {
                flag = true;
                int minIndex = findMin(number, i);

                //swap
                char temp = number[i];
                number[i] = number[minIndex];
                number[minIndex] = temp;

                //sort
                sortRemaining(number, i + 1);
                break;
            }

        }
        return flag ? new String(number) : "Not Possible";
    }

    private static void sortRemaining(char[] number, int k) {

        for (int i = k; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                if (number[i] > number[j]) {
                    char temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }

    }

    private static int findMin(char[] number, int i) {

        int minIndex = i;
        int min = Integer.MAX_VALUE;
        for (int j = i + 1; j < number.length; j++) {
            if (number[i] < number[j] && min > number[i]) {
                minIndex = j;
                min = number[j];
            }
        }
        return minIndex;
    }

}
