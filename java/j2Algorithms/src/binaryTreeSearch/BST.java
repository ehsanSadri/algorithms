package binaryTreeSearch;

class BST {

    private BstNode root;

    public BST() {
        this.root = null;
    }

    private BstNode put(BstNode node, int key, String value) {
        if (node == null) {
            return new BstNode(key, value);
        }
        if (key < node.key) {
            node.left = put(node.left, key, value);
        } else if (key > node.key) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public void put(int key, String value) {
        root = put(root, key, value);
    }

    private String get(BstNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key == node.key) {
            return node.value;
        }
        if (key < node.key) {
            return get(node.left, key);
        }
        return get(node.right, key);
    }

    public String get(int key) {
        return get(root, key);
    }

    private void inOrder(BstNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.key + " ");
        inOrder(node.right);
    }

    public void printInOrder() {
        System.out.print("InOrder: ");
        inOrder(root);
        System.out.println();
    }

    private void preOrder(BstNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.key + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void printPreOrder() {
        System.out.print("PreOrder: ");
        preOrder(root);
        System.out.println();
    }

    private BstNode min(BstNode node) {
        if (node.left == null) {
            return node;
        }
        return min(node.left);
    }

    public int min() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return min(root).key;
    }

    private BstNode max(BstNode node) {
        if (node.right == null) {
            return node;
        }
        return max(node.right);
    }

    public int max() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return max(root).key;
    }

    private int size(BstNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public int size() {
        return size(root);
    }

    private BstNode deleteMin(BstNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private BstNode delete(BstNode node, int key) {
        if (node == null) {
            return null;
        }
        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            BstNode temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private int height(BstNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int height() {
        return height(root);
    }
}

