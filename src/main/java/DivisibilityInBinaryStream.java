package main.java;

//This solution uses DFA : Deterministic Finite Automata
public final class DivisibilityInBinaryStream {
    public static void main(String[] args) {

        int n = 5;
        String stream = "1001011";

        printDivisibilityInBinaryStream(n, stream.toCharArray());


    }

    private static void printDivisibilityInBinaryStream(int n, char[] stream) {

        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0] = i*2 % n;
            arr[i][1] = (i*2 + 1) % n;
        }

        int currentRow = 0;
        for (char c : stream) {
            int k = c - 48;
            currentRow = arr[currentRow][k];
            if (currentRow == 0) {
                System.out.print("Yes ");
            } else {
                System.out.print("No ");
            }

        }

    }

}
