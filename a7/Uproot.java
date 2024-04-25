import java.util.HashMap;
import java.util.Map;

public class Uproot {
    static HashMap<Integer, Integer> answer = new HashMap<>();
    public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T) {
        postorder(T);
        return answer;
    }
    static void postorder(BinaryTreeNode T) {
        if (T == null) {
            return;
        }
        if (T.left != null)
            answer.put(T.left.key, T.key);
        if (T.right != null)
            answer.put(T.right.key, T.key);
        postorder(T.left);
        postorder(T.right);
    }

    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map) {
        Integer value = 0;
        for (Integer i: map.values()) {
            if (map.containsKey(i) == false)
                value = i;
        }
        BinaryTreeNode tree = new BinaryTreeNode(value);

        return null;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> p = new HashMap<>();
        p.put(20, 1);
        p.put(9, 1);
        p.put(14, 20);
        p.put(2, 9);
        p.put(18, 9);
        System.out.println(parentMapToTree(p));
    }
}
