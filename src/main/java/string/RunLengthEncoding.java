package string;

//https://www.geeksforgeeks.org/run-length-encoding/
public class RunLengthEncoding {
    public static void main(String[] args) {

        String word = "wwwwaaadexxxxxx";

        System.out.println("Encoded String:" + runLengthEncoding(word));

    }

    private static String runLengthEncoding(String word) {

        StringBuilder encodedString = new StringBuilder();
        for (int i = 0; i < word.length(); ) {

            char ch = word.charAt(i);
            int count = 1;
            int j;
            for (j = i + 1; j < word.length(); j++) {
                if (ch == word.charAt(j)) {
                    count++;
                } else {
                    break;
                }
            }

            i = j;

            encodedString.append(ch).append(count);


        }
        return encodedString.toString();
    }
}
