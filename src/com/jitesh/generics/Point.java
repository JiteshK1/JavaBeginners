package com.jitesh.generics;

import java.util.Arrays;

abstract class Point implements  Mappable{
    private double[] location = new double[2];

    public Point(String location) {
        this.location = stringToLatLon(location);
    }

    @Override
    public void render() {

        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }

    private String location() {
        return Arrays.toString(location);
    }
}

abstract class Park extends Point{
    private String name;


    public Park(String name,String location) {
        super(location);
        this.name = name;
    }
}