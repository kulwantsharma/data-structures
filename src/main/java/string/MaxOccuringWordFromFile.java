package string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


//https://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/
public class MaxOccuringWordFromFile {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\H359968\\Documents\\MyPersonal\\GitTest\\learning-project\\src\\main\\java\\sorting\\Word.txt");

        printMaxOccurringWords(file, 4);

    }

    private static void printMaxOccurringWords(File file, int k) throws FileNotFoundException {

//        BufferedReader br = new BufferedReader(new FileReader(file));

        Scanner scanner = new Scanner(file);
        Map<String, Integer> map = new HashMap<>();

        while (scanner.hasNext()) {
            String word = scanner.next();
            map.putIfAbsent(word, 0);
            map.put(word, map.get(word) + 1);
        }

        System.out.println(map);

//        Set<Map.Entry<String, Integer>> set =  map.entrySet();
//        List<Map.Entry<String, Integer>> list = new LinkedList<>(set);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        System.out.println(list);

        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> t1, Map.Entry<String, Integer> t2) {
                return t2.getValue() - t1.getValue();
            }
        });

        System.out.println(list);

        for (int i = 0; i < k; i++) {
            System.out.println(list.get(i).getKey());
        }


    }



}
