// TODO
public class FoodProduct implements Sellable{
    String barcode;
    double price;

    public FoodProduct(String barcode, double price) {
        this.barcode = barcode;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getAfterTaxPrice() {
        return price;
    }
}
