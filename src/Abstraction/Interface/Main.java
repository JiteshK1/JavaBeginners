package Abstraction.Interface;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        Bird bird = new Bird();
//           FlightEnabled flightEnabled = new Bird();
////        flightEnabled.land();
////           bird.fly();
////        bird.move();
//        inFLight(flightEnabled);
//inFLight(new Jet());
//        OrbitEarth.log("New Satellite " + new Satellite());

    ArrayList<Mappable> mappables= new ArrayList<>();
    mappables.add(new Building("JESUS CRISt",usageType.GOVERNMENT));
        mappables.add(new Building("ST Sebestian",usageType.RESIDENTIAL));
        mappables.add(new Building("Shiroda ",usageType.ENTERTAINMENT));

        for (var m:
                mappables
             ) {
            Mappable.mapIt(m);

        }

    }


//    public static void inFLight(FlightEnabled flightEnabled){
//        flightEnabled.land();
//        flightEnabled.fly();
//        if (flightEnabled  instanceof  Trackable trackable){
//            trackable.track();
//        }
//    }
}
