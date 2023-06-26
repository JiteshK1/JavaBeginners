package Abstraction;

public class ArtObject extends ProductForSale {

    public ArtObject(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println("This "+type+" is a beautiful product");
        System.out.printf("Their price lies between $%6.2f %n",price);
        System.out.println(description);
    }
}
