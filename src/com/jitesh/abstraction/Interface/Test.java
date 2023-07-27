package com.jitesh.abstraction.Interface;

public class Test {
    public static void main(String[] args) {

        inFLight(new Jet());
    }

    public static void inFLight(FlightEnabled flightEnabled){
        flightEnabled.land();
        flightEnabled.transition(FlightStages.GROUNDED);
        flightEnabled.fly();
        if (flightEnabled  instanceof  Trackable trackable){
            trackable.track();
        }
    }
}

