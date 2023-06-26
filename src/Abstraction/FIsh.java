package Abstraction;

public class FIsh extends Animal{
    public FIsh(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if (speed == "slow"){
            System.out.println(type = " Swimming slow");
        }
       else if (speed == "fast"){
            System.out.println(type = " Swimming Running");
        }

    }

    @Override
    public void makeNoise() {
          if (type == "goldfish"){
              System.out.println("gold gold");
          }
          else if (type == "jelly"){
              System.out.println("jelly jelly");
          }
    }
}
