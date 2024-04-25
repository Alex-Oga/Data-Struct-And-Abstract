public class Charmander extends Pokemon implements Fire, Attack{

    public Charmander(String name) {
        super(name);
        System.out.println(name + " is a Charmander");
    }

    public Charmander() {
        this("Unnamed Charmander");
    }


    @Override
    public void burn() {
        System.out.println(name + " burn level 1");
    }
}
