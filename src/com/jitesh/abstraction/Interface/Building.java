package com.jitesh.abstraction.Interface;
enum  usageType{GOVERNMENT,RESIDENTIAL,ENTERTAINMENT}
public class Building implements Mappable{
    private String name;
    private  usageType usage;

    public Building(String name, usageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
        return name +  " ( "+ usage+ " ) ";
    }

    @Override
    public geometry getShape() {
        return geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (usage){
            case GOVERNMENT -> color.BLACK+" "+pointMarket.DASH;
            case RESIDENTIAL -> color.BLUE+" "+pointMarket.DOTTED;
            case ENTERTAINMENT -> color.RED+ " "+pointMarket.SOLID;
            default -> color.PINK+" "+ pointMarket.DASH;
        };
    }
}
