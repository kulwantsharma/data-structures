package string;

//https://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-larger-than-this-number/
public class NextSmallestPalindrome {
    public static void main(String[] args) {

        //Non Palindrome
//        String number = "123456789"; //1331
        String number = "123450000004";
//        String number = "398363";
//        String number = "980";

        //Palindrome
//        String number = "1221";
//        String number = "6";

        //All 9's
//        String number = "999";
//        String number = "99999";

        System.out.println(findNextSmallestPalindrome(number.toCharArray()));

    }

    private static String findNextSmallestPalindrome(char[] number) {

        if (isPalindrome(number)) {
//            System.out.println("Originally Palindrome");

            if (checkIfAll9(number)) {
                char[] newNum = new char[number.length + 1];
                newNum[0] = 49;
                newNum[newNum.length - 1] = 49;
                for (int i = 1; i < newNum.length - 1; i++) {
                    newNum[i] = 48;
                }
                return new String(newNum);

            } else {
                increment(number);
                convertToPalindrome(number);
            }

        } else {
            //Not Palindrome
//            System.out.println("Originally Not Palindrome");
            int n = number.length;
            int i = n % 2 == 0 ? n / 2 - 1 : n / 2;
            int j = n / 2;

            while (i >= 0 && j < n) {

                boolean flag = false;
                if (number[i] < number[j]) {
                    flag = true;
                    increment(number);
                }
                if (number[i] > number[j] || flag) {
                    break;
                }
                i--;
                j++;
            }

            convertToPalindrome(number);

        }

        return new String(number);
    }

    private static void increment(char[] number) {
        int n = number.length;
        int k = n % 2 == 0 ? n / 2 - 1 : n / 2;
        int carry = 1;
        while (k >= 0) {
            int num = number[k] - 48;
            int temp = (num + carry) % 10;
            carry = (num + carry) / 10;
            number[k] = (char) (temp + 48);
            k--;
            if (carry == 0) {
                break;
            }
        }
    }

    private static boolean checkIfAll9(char[] number) {
        for (int i = 0; i < number.length; i++) {
            if (number[i] != '9') {
                return false;
            }
        }
        return true;
    }

    private static String convertToPalindrome(char[] number) {

        int i = 0;
        int j = number.length - 1;
        while (j > i) {
            number[j--] = number[i++];
        }

        return new String(number);
    }

    private static boolean isPalindrome(char[] number) {

        int j = number.length - 1;
        int i = 0;
        while (j > i) {
            if (number[i++] != number[j--]) {
                return false;
            }
        }
        return true;
    }

}
