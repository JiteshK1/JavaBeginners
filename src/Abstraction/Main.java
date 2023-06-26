package Abstraction;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("wolf", "large", 22);
        dog.move("slow");
        ArrayList<Animal> animals=new ArrayList<>();
//        animals.add(dog);
        animals.add(new FIsh("goldfish","large",221));
        animals.add(new FIsh("jelly","large",2421));
        animals.add(new FIsh("goldfish","small",121));
        animals.add(new Dog("dog","large",22111));
        animals.add(new Horse("horse","small",434));
        for (Animal animal:
             animals) {
            doAnimalStuff(animal);
        }
    }
    public static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("slow");
    }
}
