package test.furloughPractice.lru;

import java.util.*;

public class LRUCache {

    private final Map<Integer, Node> map = new HashMap<>();
    private final Queue<Node> queue = new LinkedList<>();
    private final int size;

    LRUCache(int size) {
        this.size = size;
    }

    public void refer(int referencedPage) {

        if (map.containsKey(referencedPage)) {

            Node node = new Node(referencedPage);
            queue.remove(node);
            queue.add(node);

        } else {

            Node node = new Node(referencedPage);
            if (map.size() == size) {
                Node removedNode = queue.remove();
                map.remove(removedNode.data);
                map.put(referencedPage, node);
                queue.add(node);
            } else {
                map.put(referencedPage, node);
                queue.add(node);
            }

        }

    }

    public void display() {

        Iterator<Node> itr = queue.iterator();
        System.out.print("[");
        while (itr.hasNext()) {
            System.out.print(itr.next().data + " ");
        }
        System.out.println("]");
    }
}
