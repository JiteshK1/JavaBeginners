package Abstraction;

public abstract class Animal {
    protected String type;
    protected String size;
    protected double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);

    public abstract void makeNoise();

}
