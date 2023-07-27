package com.jitesh.oop;

public class Item {
    private String type;
    private String name;
    private double price;
    private String size = "MEDIUM";

    public String getName() {
        if (type.equals("DRINK") | type.equals("SIDE")){
            return name + " " +size;
        };
        return name;
    }
    public void setSize(String size) {
        this.size = size;
    }


    public Item(String name, String type, double price) {
        this.name = name.toUpperCase();
        this.type = type.toUpperCase();
        this.price = price;
    }


    public String getSize() {
        return size;
    }

    public static void printItem(String name, double price) {
        System.out.printf("%20s:%6.2f%n", name, price);
    }

    public double getAdjustedPrice() {
        return switch (size) {
            case "SMALL" -> getBasePrice() - 0.5;
            case "LARGE" -> getBasePrice() + 1;
            default -> getBasePrice();
        };
    }

    public double getBasePrice() {
        return price;
    }
}
