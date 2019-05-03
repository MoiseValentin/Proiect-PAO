package product;

public class Salad extends Product {
    private String type;

    public Salad(String name, double price, String type) {
        super(name, price);
        this.productType ="Salad";
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return this.getProductType() +","+
                this.getName()+","+
                this.getPrice()+","+
                this.getType();
    }
}
