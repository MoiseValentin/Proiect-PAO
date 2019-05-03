package product;

public class Pizza extends Product {
    private boolean vegetarian;

    public Pizza(String name, double price, boolean vegetarian) {
        super(name, price);
        this.productType ="Pizza";
        this.vegetarian = vegetarian;
    }

    public boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return this.getProductType() +","+
                this.getName()+","+
                this.getPrice()+","+
                this.getVegetarian();
    }
}
