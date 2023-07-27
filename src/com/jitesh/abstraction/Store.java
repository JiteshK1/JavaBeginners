package com.jitesh.abstraction;

import java.util.ArrayList;

public class Store {
    //manage a list of products for sale display product details

    public static ArrayList<ProductForSale> salesProduct = new ArrayList<>();
    public static void main(String[] args) {
        salesProduct.add(new ArtObject("Wooden",221.1,"This is the piece of Art of the wooden table"));
        salesProduct.add(new ArtObject("Chair",11.1,"Wooden Chair are made for the relaxed folks using it"));
    listItem(salesProduct);
    ArrayList<OrderItem> order1= new ArrayList<>();
    addOrderItems(order1,0,2);
    printOrder(order1);

    }
    public static void  listItem(ArrayList<ProductForSale> salesProduct){
        for (var item:
             salesProduct) {
            item.showDetails();
        }
    }


public static void addOrderItems(ArrayList<OrderItem> order,int orderIndex,int quantity){
        order.add(new OrderItem(quantity,salesProduct.get(orderIndex)));;
}
    // manage an order, which can just be a list of OrderItem objects


public  static void printOrder(ArrayList<OrderItem> order){
    double totalSales=0;
        for (var item:
         order) {
        item.product().printPriceItem(item.Quantity());
         totalSales+=item.product().getSalesPrice(item.Quantity());

    }
    System.out.println("Total price of Sales are "+totalSales);
}
    //have methods to add an item on the order and print the ordered item
}
