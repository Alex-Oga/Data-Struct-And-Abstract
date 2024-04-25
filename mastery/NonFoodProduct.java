// TODO
public class NonFoodProduct implements Sellable{
    String barcode;
    double price;
    double taxRate;

    public NonFoodProduct(String barCode, double price, double taxRate) {
        this.barcode = barCode;
        this.price = price;
        this.taxRate = taxRate;
    }

    public String getBarcode() {
        return barcode;
    }

    public double getAfterTaxPrice() {
        return price * taxRate + price;
    }
}
