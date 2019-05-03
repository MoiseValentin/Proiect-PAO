package product;

public class Drink extends Product {

    public Drink(String name, double price) {
        super(name, price);
        this.productType ="Drink";
    }

    @Override
    public String toString() {
        return this.getProductType() +","+
                this.getName()+","+
                this.getPrice();
    }
}
