package binaryTreeSearch;

public class BstRunner {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(10, "A");
        bst.put(2, "B");
        bst.put(11, "C");
        bst.put(8, "D");
        bst.put(15, "E");
        bst.put(12, "F");
        bst.put(4, "G");
        bst.put(1, "H");
        bst.printInOrder();
        bst.printPreOrder();
        System.out.println("Min Key: " + bst.min());
        System.out.println("Max Key: " + bst.max());

        bst.deleteMin();
        bst.deleteMin();
        System.out.println("\n** After 2 Delete Mins **");
        bst.printInOrder();
        bst.printPreOrder();

        bst.put(7, "I");
        bst.put(16, "J");
        System.out.println("\n** After Adding 7, 16 **");
        bst.printInOrder();
        bst.printPreOrder();

        bst.delete(4);
        bst.delete(10);
        bst.delete(8);
        System.out.println("\n** After Deleting 4, 10, 8 **");
        bst.printInOrder();
        bst.printPreOrder();
    }
}