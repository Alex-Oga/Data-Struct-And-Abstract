public class MyTreeMap<K extends Comparable<K>, V> {
    K key;
    V value;
    MyTreeMap<K, V> left, right;


    V get(K k) {
        if (key.compareTo(k) == 0) {
            return value;
        }
        else if (key.compareTo(k) > 0) {
            return left.get(k);
        }
        else if (key.compareTo(k) < 0) {
            return right.get(k);
        }
        else
            return null;
    }
    void put(K k, V v) {

        if (key == null) {
            key = k;
            value = v;
        }
        else if(key.compareTo(k) > 0 && left == null) {
            left = new MyTreeMap<>();
            left.put(k, v);
        }
        else if(key.compareTo(k) < 0 && right == null) {
            right = new MyTreeMap<>();
            right.put(k, v);
        }
        else if(left != null && key.compareTo(k) > 0) {
            MyTreeMap current = left;
            current.put(k, v);
        }
        else if( right != null && key.compareTo(k) < 0) {
            MyTreeMap current = right;
            current.put(k, v);
        }
    }

    K lowerKey(K k) {
        if (key.compareTo(k) < 0 && right == null)
            return key;
        else if (key.compareTo(k) < 0 && right != null && right.key.compareTo(k) >= 0) {
            return key;
        }
        else if (key.compareTo(k) >= 0 && left != null && left.key.compareTo(k) <= 0) {
            return left.lowerKey(k);
        }
        else if (key.compareTo(k) < 0 && right != null && right.key.compareTo(k) < 0) {
            return right.lowerKey(k);
        }
        return null;
    }

    public static void main(String[] args) {
        MyTreeMap test = new MyTreeMap();
        test.put(1, 2);
        test.put(2, 3);
        test.put(3, 4);
        test.put(0, 1);
        test.put(-1, 0);
        System.out.println(test.lowerKey(4));
        System.out.println(test.get(4));
    }
}
