package string;

//https://practice.geeksforgeeks.org/problems/remove-b-and-ac-from-a-given-string4336/1
public class RemoveBandAC {
    public static void main(String[] args) {

        String str = "aacbacc";

//        str = remove(str);
//        System.out.println(str);

        str = remove1(str);
        System.out.println(str);


    }

    private static String remove1(String str) {

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < str.length()) {

            if (str.charAt(i) == 'b') {
                i++;
            } else if (str.charAt(i) == 'a' && i + 1 < str.length() && str.charAt(i + 1) == 'c') {
                i += 2;
            } else {
                result.append(str.charAt(i));
                i++;
            }
        }

        return result.toString();
    }

    private static String remove(String str) {

        str = str.replace("b", "");
        str = str.replace("ac", "");
        return str;
    }
}
