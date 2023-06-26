package Abstraction.Interface;

public class Bird extends  Animal implements FlightEnabled,Trackable{
    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " Taking off");
    }

    @Override
    public void land() {
        System.out.println(getClass().getSimpleName() + " Landing");

    }

    @Override
    public void fly() {
        System.out.println(getClass().getSimpleName() + " Flying");

    }

    @Override
    public void track() {
        System.out.println(getClass().getSimpleName() + " Getting coordinates");

    }

    @Override
    void move() {
        System.out.println(getClass().getSimpleName() + " Wing Flapping");


    }
}
