public class Product {
    private String productID;
    private String productName;
    private String productBrand;
    private double productPrice;
    private String productAvailability;

    public Product(String id, String name, String brand, double price, String available) {
        this.productID = id;
        this.productName = name;
        this.productBrand = brand;
        this.productPrice = price;
        this.productAvailability = available;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductBrand(String brand) {
        this.productBrand = brand;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductAvailability(String productAvailability) {
        this.productAvailability = productAvailability;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductAvailability() {
        return productAvailability;
    }

    public String toString() { //1
        return (this.productID + "," + this.productName + "," + this.productBrand + "," + this.productPrice + "," + this.productAvailability);
    }

}
