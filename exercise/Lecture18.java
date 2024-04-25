public class Lecture18 {
    static int total = 0;
    static StringBuilder str = new StringBuilder();
    class TreeNode<E> {
        E key;
        TreeNode<E> left, right;

        // constructors omitted
    }

    public static int count(TreeNode<?> tree) {
        if (tree == null)
            return 0;

        preOrder(tree);
        return total;
    }

    public static String concatPreorder(TreeNode<String> tree) {
        preOrderString(tree);

        return str.toString();
    }

    public static void preOrder(TreeNode<?> tree) {
        if (tree == null)
            return;
        total += 1;
        preOrder(tree.left);
        preOrder(tree.right);
    }

    public static void preOrderString(TreeNode<?> tree) {
        if (tree == null)
            return;
        str.append(tree.key);
        preOrderString(tree.left);
        preOrderString(tree.right);
    }

    public static void main(String[] args) {
        Lecture18 clas = new Lecture18();
        Lecture18.TreeNode a = clas.new TreeNode();
        a.key = "A";
        Lecture18.TreeNode b = clas.new TreeNode();
        b.key = "B";
        Lecture18.TreeNode c = clas.new TreeNode();
        c.key = "C";
        Lecture18.TreeNode d = clas.new TreeNode();
        d.key = "D";
        Lecture18.TreeNode e = clas.new TreeNode();
        e.key = "E";
        Lecture18.TreeNode f = clas.new TreeNode();
        f.key = "F";

        a.left = c;
        a.right = b;
        c.left = d;
        b.left = e;
        b.right = f;

        System.out.println(count(a));
        System.out.println(concatPreorder(a));
    }
}
