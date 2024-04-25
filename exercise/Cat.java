public class Cat implements HasIsLarger<Cat>{
    private String name;
    private int weight;
    private int age;

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public String getName() { return name; }
    public int getWeight() { return weight; }
    public int getAge() { return age; }

    public boolean isLargerThan(Cat that) {
        return this.getWeight() > that.getWeight();
    }
}
