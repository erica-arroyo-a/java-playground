class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

/*
Tree Traversal
IN-order visits the nodes in order (if a BST)
in-oder:
    go(left)
    visit(me) --> root
    go(right)
PRE-order visits the nodes before recursing
pre-order:
    visit(me) --> root
    go(left)
    go(right)
POST-order visits the nodes after recursing
post-order:
    go(left)
    go(right)
    visit(me) --> root


Balanced: O(log N) insert, find
Unbalanced: O(N) in worst case
 */

class BinaryTree {
    TreeNode root;
    TreeNode head;
    TreeNode prev;

    public BinaryTree() {
        this.root = null;
        this.head = null;
        this.prev = null;
    }

    // Recursive convert function
    public void convert(TreeNode node) {
        if (node == null) {
            return;
        }

        // Convert left subtree
        convert(node.left);

        // Process current node
        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }
        prev = node;

        // Convert right subtree
        convert(node.right);
    }

    public void printList(TreeNode head) {
        TreeNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.right;
        }
        System.out.println();
    }

    /*
         10
        /   \
      12     15
     /  \   /
    25 30  36
     */
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(12);
        tree.root.right = new TreeNode(15);
        tree.root.left.left = new TreeNode(25);
        tree.root.left.right = new TreeNode(30);
        tree.root.right.left = new TreeNode(36);

        tree.convert(tree.root);
        tree.printList(tree.head);
    }
}