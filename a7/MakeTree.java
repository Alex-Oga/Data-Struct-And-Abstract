public class MakeTree {
    static BinaryTreeNode root;

    public static BinaryTreeNode buildBST(int[] keys) {
        for (int i: keys) {
            root = treeAdd(root, i);
        }
        return root;
    }

    private static BinaryTreeNode treeAdd(BinaryTreeNode current, int value) {
        if (current == null) {
            return new BinaryTreeNode(value);
        }
        if (value < current.key) {
            current.left = treeAdd(current.left, value);
        } else if (value > current.key) {
            current.right = treeAdd(current.right, value);
        }
        else {
            return current;
        }
        return current;
    }
}
