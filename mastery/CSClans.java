import java.util.*;
public class CSClans {
    Map<String, Double> a = new HashMap<>();
    Map<String, Integer> cats = new HashMap<>();
    List<Set<String>> catClan = new ArrayList<>();
    void set(String name, int evilAura) {
        if (cats.get(name) != null)
            cats.replace(name, evilAura);
        cats.put(name, evilAura);
    }

    void tailShake(String catA, String catB) {
        int count = 0;
        for (Set<String> i : catClan) {
            if (i.contains(catA) || i.contains(catB)) {
                i.add(catA);
                i.add(catB);
                count++;
            }
        }
        if (count == 0) {
            Set<String> ad = new HashSet<>();
            ad.add(catA);
            ad.add(catB);
            catClan.add(ad);
        }
    }

    Map<String, Double> report() {
        for (Set<String> i: catClan) {
            double al = 0;
            int allCats = i.size();
            int biggest = 0;
            String BiggestCat = "";
            for (String j: i) {
                al += cats.get(j);
                if (cats.get(j) > biggest) {
                    BiggestCat = j;
                    biggest = cats.get(j);
                }
            }
            a.put(BiggestCat, al/allCats);
        }
        checker(catClan);
        return a;
    }

    void checker(List<Set<String>> clans) {
        for (Map.Entry<String, Integer> entry: cats.entrySet()) {
            int count = 0;
            for (Set<String> i: catClan) {
                if (i.contains(entry.getKey()))
                    count++;
            }
            if (count == 0) {
                a.put(entry.getKey(), cats.get(entry.getKey())+0.0);
            }
        }
    }

    public static void main(String[] args) {
        {
            CSClans cs = new CSClans();
            cs.set("Taro", 50);
            cs.set("Yellow", 100);
            cs.set("Tabot", 1);
            cs.tailShake("Taro", "Tabot");
            cs.set("Tabot", 100);
            Map<String, Double> expected = Map.of("Yellow", 100.0, "Tabot", 75.0);
            Map<String, Double> yourAnswer = cs.report();
            System.out.println(yourAnswer);
            System.out.println(expected.equals(yourAnswer));
        }
        {
            CSClans cs = new CSClans();
            cs.set("Beth", 8);
            cs.set("Deb", 50);
            cs.set("Jolie", 2);
            cs.set("Alice", 23);
            cs.tailShake("Jolie", "Deb");
            cs.set("Jolie", 10);
            cs.set("Vera", 4);
            cs.set("Cathy", 21);
            cs.tailShake("Cathy","Beth");
            cs.tailShake("Beth","Vera");
            cs.set("Alice", 21);
            // expect: {Deb=30.0, Alice=21.0, Cathy=11.0}
            Map<String, Double> expected = Map.of("Deb",30.0, "Alice", 21.0, "Cathy", 11.0);
            Map<String, Double> yourAnswer = cs.report();
            System.out.println(yourAnswer);
            System.out.println(expected.equals(yourAnswer));
        }
        {
            CSClans cs = new CSClans();
            int n = 100000;
            for (int i=0;i<n;i++) cs.set("c"+i, 0); // all cats with 0 evilness
            int p = 10000;
            for (int b=0;b<n;b+=p) {
                for (int i=0;i<p-1;i++) {
                    cs.tailShake("c" + (b + i), "c" + (b + i + 1));
                    cs.set("c"+(b+i), (b/p)+p-i);
                }
            }
            Map<String, Double> expected = Map.of(
                    "c40000", 5004.4995, "c50000", 5005.4994, "c30000", 5003.4996, "c10000",
                    5001.4998, "c20000", 5002.4997, "c70000", 5007.4992, "c60000", 5006.4993,
                    "c0", 5000.4999, "c80000", 5008.4991, "c90000", 5009.499
            );
            Map<String, Double> yourAnswer = cs.report();
            System.out.println(yourAnswer);
            System.out.println(expected.equals(yourAnswer));
            // expect:
            // {c40000=5004.4995, c50000=5005.4994, c30000=5003.4996, c10000=5001.4998, c20000=5002.4997, c70000=5007.4992, c60000=5006.4993, c0=5000.4999, c80000=5008.4991, c90000=5009.499}
        }
    }
}

