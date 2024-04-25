public class Pokemon implements Attack{
    public String name;
    private int magicNum = 77;

    public Pokemon(String name) {
        this.name = name;
        System.out.println(name + " is ready");
    }

    public Pokemon() {
        this("Unknown");
    }

    public void attack() {
        System.out.println(name + " attack!");
    }

    public void teleport(int n) {
        System.out.println(name + " teleport!");
        if (n > 0)
            throw new IndexOutOfBoundsException();
        System.out.println("Done!");
    }
}
