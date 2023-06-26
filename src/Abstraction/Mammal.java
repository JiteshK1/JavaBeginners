package Abstraction;

public abstract class Mammal extends Animal {
    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    public  void move(String speed){
        System.out.println(getClass().getSimpleName());
        System.out.println(type=="slow"?"walk":"Run");
    }

    public abstract void shedHair();
}
