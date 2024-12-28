package binaryTreeSearch;

public class BstNode {
    int key;
    String value;
    BstNode left, right;

    public BstNode(int key, String value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }
}