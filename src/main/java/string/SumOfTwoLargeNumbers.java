package string;

//https://www.geeksforgeeks.org/sum-two-large-numbers/
public class SumOfTwoLargeNumbers {
    public static void main(String[] args) {

        String str1 = "3333311111111111";
        String str2 = "44422222221111";

        System.out.println(getSum(str1, str2));
    }

    private static String getSum(String str1, String str2) {

        int i = str1.length() - 1;
        int j = str2.length() - 1;

        int carry = 0;
        String result = "";
        while (i >= 0 || j >= 0) {
            int sum = (i >= 0 ? str1.charAt(i) - 48 : 0) + (j >= 0 ? str2.charAt(j) - 48 : 0) + carry;
            result = (sum % 10) + result;
            carry = sum / 10;
            if (i >= 0) i--;
            if (j >= 0) j--;
        }
        return result;
    }
}
