package com.jitesh.abstraction;

public abstract class ProductForSale {
    protected  String type;

    public ProductForSale(String type, double price, String description) {
        this.type = type;
        this.price = price;
        this.description = description;
    }

    protected  double price;
    protected String description;

    //sales price a concrete method which takes quantity and returns the quantity times the price
    public double getSalesPrice(int quantity){
        return quantity * price;
    }
    // print a priced line item, a concrete method which takes a quantity and should print an itemized line item for an order
    //with quantity and line item price
    public  void  printPriceItem(int quantity){
        System.out.println();
    }

    //show details an abstract method represents what might be displayed on product page type description price and so on

    public abstract void  showDetails();
    //create an orderItem type that has a minimum of 2 field Quantity    and a product for sale

}

record OrderItem(int Quantity, ProductForSale product){}
