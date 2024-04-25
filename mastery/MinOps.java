import java.util.*;

public class MinOps {
    public int minimumOps(List<Integer> S, List<Integer> T) {
        // TODO: Write me
        return -1;
    }


    public static void main(String[] args) {
        MinOps minOps = new MinOps();
        List<Integer> l1 = List.of(1,2,3,4,5);
        List<Integer> l2 = List.of(2,1,5,4,3);
        List<Integer> l3 = List.of(1,5,4,3,2);
        List<Integer> l4 = List.of(1,2,3,4,5);
        List<Integer> l5 = List.of(5,4,3,2,1);
        System.out.println(l1 + " -> " + l1 + " :: " + minOps.minimumOps(l1,l1)); // 0
        System.out.println(l1 + " -> " + l2 + " :: " + minOps.minimumOps(l1,l2)); // 3
        System.out.println(l1 + " -> " + l3 + " :: " + minOps.minimumOps(l1,l3)); // 2
        System.out.println(l1 + " -> " + l4 + " :: " + minOps.minimumOps(l1,l4)); // 0
        System.out.println(l1 + " -> " + l5 + " :: " + minOps.minimumOps(l1,l5)); // 1
        System.out.println(l5 + " -> " + l3 + " :: " + minOps.minimumOps(l5,l3)); // 1
    }


}
