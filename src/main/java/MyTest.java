
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class Test1 {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\H359968\\Desktop\\pod.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line = "";
        StringBuffer finalString = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            finalString.append(line);
        }
        System.out.println(finalString);
    }
}