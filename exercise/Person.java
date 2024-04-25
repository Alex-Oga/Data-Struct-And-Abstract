public class Person {
    int age;

    public void setAge(int age) throws DataOutOfBoundsException{

        if (age < 0 || age > 120)
            throw new DataOutOfBoundsException(""+age);

        this.age = age;
    }

    public void makePerson() {
        Person clone = new Person();
        int random = (int) (Math.random() * 1000);
        try {
            clone.setAge(random);
        }
        catch (DataOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Person a = new Person();
        a.makePerson();
    }
}
