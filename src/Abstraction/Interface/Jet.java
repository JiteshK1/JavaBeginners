package Abstraction.Interface;


public class Jet implements   FlightEnabled, Trackable{
    @Override
    public void takeOff() {
        System.out.println(getClass().getSimpleName() + " Taking off");
    }

    @Override
    public FlightStages transition(FlightStages stages) {
        System.out.println(getClass().getSimpleName()+" transition");
        return  FlightEnabled.super.transition(stages);
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


}
