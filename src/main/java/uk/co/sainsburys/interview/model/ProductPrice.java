package uk.co.sainsburys.interview.model;

public class ProductPrice {
    private String productUid;
    private double price;
    private String measure;
    private int measureAmount;

    // Getters and Setters
    public String getProductUid() {
        return productUid;
    }

    public void setProductUid(String productUid) {
        this.productUid = productUid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public int getMeasureAmount() {
        return measureAmount;
    }

    public void setMeasureAmount(int measureAmount) {
        this.measureAmount = measureAmount;
    }
}
