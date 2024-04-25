import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

interface Series {
    int next();
    void reset();
}

class IncrByTwo implements Series {
    private int x = -2;

    public int next() {
        return x += 2;
    }

    public void reset() { x = -2; }

}
class ConstFive implements Series {
    public int next() { return 5; }
    public void reset() {}
}

class Animal {
    public void walk() {
        System.out.println("Animal: Walking");
    }
    public void eat() {
        System.out.println("Animal: Eating");
    }
}

class Pet extends Animal {
    void play(String with) {
        System.out.println("Pet: play with" + with);
    }
}

class Parrot extends Pet {
    void sing() {
        System.out.println("Parrot: Singing");
    }
}

public class Lecture6 {

    public static int sumALl(List<Integer> arr) {
        int total = 0;
        for (int elt: arr) {
            total += elt;
        }
        return total;
    }

    public static int sumALl(ArrayList<Integer> arr) {
        int total = 0;
        for (int elt: arr) {
            total += elt;
        }
        return total;
    }
    public static int sumALl(LinkedList<Integer> arr) {
        int total = 0;
        for (int elt: arr) {
            total += elt;
        }
        return total;
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        Pet p = new Pet();
        Parrot pp = new Parrot();

        ArrayList<String> arr = new ArrayList<>();
        List<String> altArr = new ArrayList<>(); // Preferred
        /*
        IncrByTwo s1 = new IncrByTwo();
        Series s2 = new IncrByTwo();
        ConstFive s3 = new ConstFive();
        Series[] ss = {s1, s2, s3};
        List<Integer> ll = new ArrayList<>();
        System.out.println(s1.next());
        System.out.println(s1.next());
        s1.reset();
        System.out.println(s1.next());
        */
    }
}
