package main.java.graph;

import java.util.ArrayList;

public final class DFS {
    public static void main(String[] args) {

        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        graph.doDFS(2);

    }

    static class Graph {

        private final int size;
        private ArrayList[] arrayLists = null;

        public Graph(int size) {
            this.size = size;
            arrayLists = new ArrayList[size];

            for (int i = 0; i < size; i++) {
                arrayLists[i] = new ArrayList<Integer>();
            }

        }

        public void addEdge(int u, int v) {

            arrayLists[u].add(v);

        }

        public void doDFS(int root) {

            boolean[] visited = new boolean[size];
            doDFSUtil(root, visited);

        }

        private void doDFSUtil(int root, boolean[] visited) {

            if (visited[root]) {
                return;
            }
            System.out.print(root + " ");
            visited[root] = true;

            for (int i = 0; i < arrayLists[root].size(); i++) {

                int adjacentVertex = (int) arrayLists[root].get(i);
                doDFSUtil(adjacentVertex, visited);

            }


        }
    }
}
