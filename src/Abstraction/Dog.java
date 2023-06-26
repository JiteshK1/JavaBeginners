package Abstraction;

public class Dog extends Animal{
    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed == "slow"){
            System.out.println(type = " Walk");
        }
       else if (speed == "fast"){
            System.out.println(type = " Running");
        }

    }

    @Override
    public void makeNoise() {
          if (type == "wolf"){
              System.out.println("Howling");
          }
          else if (type == "dog"){
              System.out.println("Woof");
          }
    }
}
