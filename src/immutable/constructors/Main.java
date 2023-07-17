package immutable.constructors;

public class Main {
    public static void main(String[] args) {
Parent parent = new Parent("jitesh","23,12,1",4);
        Child child = new Child();
        System.out.println("=====================");
        System.out.println("Parent: " + parent);
        System.out.println("Child: " + child);

        Person person = new Person("Jitesh","05-01-2003");
        Person personCopy = new Person(person);
        Person person2 = new Person("Prakash","05-01-2003");
        System.out.println(person);
        System.out.println(personCopy);

        Generation g = Generation.GEN_X;
    }
}
