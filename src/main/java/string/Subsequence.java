package string;

//https://www.geeksforgeeks.org/given-two-strings-find-first-string-subsequence-second/
public class Subsequence {
    public static void main(String[] args) {

//        String str1 = "AXD";
//        String str2 = "ADXCPY";

        String str1 = "gksrek";
        String str2 = "geeksforgeeks";

        System.out.println(isSubSequence(str1, str2, 0, ""));


    }

    private static boolean isSubSequence(String str1, String str2, int length, String subSequence) {

        if (length == str2.length()) {
            if (str1.equals(subSequence)) return true;
            else return false;
        }
        return isSubSequence(str1, str2, length + 1, subSequence + str2.charAt(length)) ||
                isSubSequence(str1, str2, length + 1, subSequence);
    }


}
