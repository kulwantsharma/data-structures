package ternary;

public class Node {
    Node left;
    Node right;
    Node equal;
    boolean isEndOfWord;
    char data;
    Node(char data){
        this.data = data;
    }
}
