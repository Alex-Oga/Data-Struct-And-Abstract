public class Puzzle {

    public static void stageAttack(Attack o) {
        o.attack();
    }

    public static void stageBurn(Fire o) {
        o.burn();
    }

    public static void main(String[] args) {
        Charmander c = new Charmander("Johny");
        Pokemon p = new Pokemon();
        c.burn();
        stageAttack(p);
        stageAttack(c);
        stageBurn(c);
        System.out.println(c.name);
        try {
            p.teleport(5);
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Fail to teleport");
        }
    }
}
