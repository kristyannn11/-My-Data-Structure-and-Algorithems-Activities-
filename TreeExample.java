class TreeExample {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(20);
        tree.root.left = new Node(10);
        tree.root.right = new Node(30);
        tree.inorder(tree.root);
    }
}

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }
}
