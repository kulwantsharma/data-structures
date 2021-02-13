import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Test {
    public static void main(String[] args) throws IOException {


        FileWriter fileWriter = new FileWriter(new File("Fan6000.csv"));

        String header = "Asset Name,Asset Type, Point Label, Actual Point Name, Point Id, Description, Point Role, System GUID, AI, AO, DI, DO, SW, History Type, Interval, Delete, Driver Type,Capacity Record Count";
        fileWriter.write(header);
        fileWriter.write("\n");
        String str = "slot$3a$2fTest$2fFan";

        for (int i = 1; i <= 3000; i++) {

            fileWriter.write(",,,," + str + i + ",,,honeywell,,,,,,INTERVAL,120,,,1000");
            fileWriter.write("\n");
        }

        for (int i = 3001; i <= 6000; i++) {

            fileWriter.write(",,,," + str + i + ",,,tridium,,,,,,INTERVAL,120,,,1000");
            fileWriter.write("\n");
        }
//        for (int i = 6001; i <= 10000; i++) {
//
//            fileWriter.write(",,,," + str + i + ",,,tridium,,,,,,INTERVAL,120,,,1000");
//            fileWriter.write("\n");
//        }
        fileWriter.close();
    }


}

class LRUCache {

    Map<Integer, Node> map = new HashMap<>();
    LinkedList<Node> list = new LinkedList<>();

    private int size;

    LRUCache(int size) {
        this.size = size;
    }

    public void refer(int key) {

        //check if the key is in the map
        if (map.containsKey(key)) {

            Node node = map.get(key);
            list.remove(node);
            list.add(node);

        } else {

            Node node = new Node(key);
            //cache is full
            if (list.size() == size) {
                Node temp = list.removeFirst();
                list.add(node);
                map.remove(temp.data);
            } else {
                list.add(node);
                map.put(key, node);
            }

        }

    }

    public void print() {

        Iterator<Node> iterator = list.iterator();

        System.out.print('[');
        while (iterator.hasNext()) {
            System.out.print(iterator.next().data + " ");
        }
        System.out.println(']');
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return data == node.data &&
                    Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }
    }

}