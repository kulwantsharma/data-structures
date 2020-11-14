package string;

//https://www.geeksforgeeks.org/replace-every-character-of-a-string-by-a-different-character/
public class ReplaceEveryCharacterOfAString {
    public static void main(String[] args) {

        String str = "geeksforgeeks";

        System.out.println(replaceEveryCharacter(str.toCharArray()));

    }

    private static String replaceEveryCharacter(char[] str) {

        for (int i = 0; i < str.length; i++) {

            int ascii = str[i];
            str[i] = (char) (97 + (ascii + ascii - 97 + 1) % 26 - 1);
        }

        return new String(str);
    }
}
