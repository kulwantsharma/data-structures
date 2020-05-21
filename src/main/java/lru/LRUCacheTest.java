package main.java.lru;

public class LRUCacheTest {
    public static void main(String[] args) {

        int[] pages = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        LRUCache ca = new LRUCache(4);

       for(int i=0;i<pages.length;i++){
           ca.refer(pages[i]);
           ca.display();
       }
    }
}
