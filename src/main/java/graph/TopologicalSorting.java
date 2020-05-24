package main.java.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public final class TopologicalSorting {
    public static void main(String[] args) {

        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.topologicalSort();


    }

    static class Graph {

        private final int V;
        private LinkedList<Integer>[] adjacencyList = null;

        public Graph(int v) {
            this.V = v;
            adjacencyList = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adjacencyList[i] = new LinkedList();
            }

        }

        public void addEdge(int u, int v) {

            adjacencyList[u].add(v);

        }


        public void topologicalSort() {

            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < V; i++) {
                topologicalSortUtil(i, visited, stack);
            }

            System.out.println("Topologically Sorted");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }

        }

        private void topologicalSortUtil(int i, boolean[] visited, Stack<Integer> stack) {

            if (visited[i]) return;

            visited[i] = true;
            LinkedList<Integer> adjNodes = adjacencyList[i];
            Iterator<Integer> iterator = adjNodes.iterator();

            while (iterator.hasNext()) {
                topologicalSortUtil(iterator.next(), visited, stack);
            }
            stack.push(i);
        }
    }
}
