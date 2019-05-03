package product;

public class AlcoholicDrink extends Product {
    private double alcoholQuantity;

    public AlcoholicDrink(String name, double price, double alcohol) {
        super(name, price);
        this.alcoholQuantity = alcohol;
        this.productType ="AlcoholicDrink";
    }

    public double getAlcohol() {
        return alcoholQuantity;
    }

    public void setAlcohol(double alcohol) {
        this.alcoholQuantity = alcohol;
    }

    @Override
    public String toString() {
        return this.getProductType() + "," +
                this.getName() + "," +
                this.getPrice() + "," +
                this.getAlcohol();
    }

}
