package com.jitesh.nested_classes.burger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Meal {

    private Burger burger;
    private Item drink;
    private Item side;
    private double base=5.0;

    public Meal(){
        this.burger=new Burger("regular");
        this.drink=new Item("Cola","drink",2.2);
        this.side=new Item("French","side",1.2);

    }

public void addToppings(String... selectedTopping){
        burger.addToppings(selectedTopping);
}
    public class Burger extends Item{
        private enum Extra {AVOCADO, BACON, CHEESE, KETCHUP, MAYO, MUSTARD, PICKLES;

            private double getPrice() {
                return switch (this) {
                    case AVOCADO -> 1.0;
                    case BACON, CHEESE -> 1.5;
                    default -> 0;
                };
            }

        }

        List<Item> toppings = new ArrayList<>();

        public Burger(String name) {
            super(name, "Burger", 5.0);
        }

        public void addToppings(String... selectedToppings){
            for (String top: selectedToppings){
                Extra topping = Extra.valueOf(top.toUpperCase());
                toppings.add(new Item(topping.name(),"TOPPING",topping.getPrice()));
            }

        }

    }


    public class Item{

        private String name;

        private String type;
        private Double price;

        public Item(String name, String type) {
           this(name,type, type.equalsIgnoreCase("Burger") ?base:0.0);
        }

        public Item(String name, String type, Double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }
        @Override
        public String toString() {
            return "%10s%15s".formatted(type, name);
        }
    }
}
