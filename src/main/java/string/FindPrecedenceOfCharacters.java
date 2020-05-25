package main.java.string;

import java.util.LinkedList;
import java.util.Stack;

//https://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
public final class FindPrecedenceOfCharacters {
    public static void main(String[] args) {

        String[] words = {"baa", "abcd", "abca", "cab", "cad"};

        printOrder(words, 4);

    }

    private static void printOrder(String[] words, int totalAphabets) {

        Graph graph = new Graph(totalAphabets);

        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            while (words[i].charAt(j) == words[i + 1].charAt(j)) {
                j++;
            }
            graph.addEdge(words[i].charAt(j) - 'a', words[i + 1].charAt(j) - 'a');
        }

        Stack stack = graph.topologicalSort();

        while (!stack.isEmpty()) {
            char alphabet =(char)((int)stack.pop() + new Integer(97));
            System.out.print(alphabet + " ");
        }

    }

    static class Graph {

        //No of Vertices
        private final int V;
        private LinkedList<Integer>[] adjacentList;

        Graph(int v) {
            this.V = v;
            adjacentList = new LinkedList[v];
            for (int i = 0; i < V; i++) {
                adjacentList[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int u, int v) {
            adjacentList[u].add(v);
        }

        public Stack topologicalSort() {
            boolean[] visited = new boolean[V];
            Stack<Integer> stack = new Stack<>();
            for (int vertexIndex = 0; vertexIndex < V; vertexIndex++) {
                if (!visited[vertexIndex])
                    topologicalSortUtil(vertexIndex, visited, stack);
            }

            return stack;
        }

        private void topologicalSortUtil(int vertexIndex, boolean[] visited, Stack<Integer> stack) {

            visited[vertexIndex] = true;

            for (int adjVertex : adjacentList[vertexIndex]) {
                if (!visited[adjVertex]) {
                    topologicalSortUtil(adjVertex, visited, stack);
                }
            }
            stack.push(vertexIndex);
        }
    }
}
