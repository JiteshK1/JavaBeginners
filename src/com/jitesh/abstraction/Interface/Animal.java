package com.jitesh.abstraction.Interface;


class Satellite implements OrbitEarth {

    public void achieveOrbit() {
        System.out.println("Orbit achieved!");
    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

interface OrbitEarth extends FlightEnabled {

    void achieveOrbit();
    static  void log(String Description){
        Object today= new java.util.Date();
        System.out.println(today+ " : "+Description);
    }
}


enum FlightStages implements Trackable {
    GROUNDED, LAUNCH, CRUISE, DATA_COLLECTION;

    @Override
    public void track() {

        if (this != GROUNDED) {
            System.out.println("Monitoring " + this);
        }
    }
    public  FlightStages getNextStages(){
        FlightStages[] allStages= values();
        return allStages[(ordinal()+1)% allStages.length];
    }

}

record DragonFly(String name, String type) implements FlightEnabled {

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}

interface FlightEnabled {
    double MILES_TO_KM = 1.60934;
    double KM_TO_MILES = 0.621371;

    void takeOff();

    void land();

    void fly();

    default FlightStages transition(FlightStages stages) {
        System.out.println(getClass().getSimpleName() + " is not yet transited");
        FlightStages nextStage= stages.getNextStages();
        System.out.println("Transitioning for "+stages+" tp "+ nextStage);
        return nextStage;
    }
}

interface Trackable {
    void track();


}

public abstract class Animal {
    abstract void move();
}
