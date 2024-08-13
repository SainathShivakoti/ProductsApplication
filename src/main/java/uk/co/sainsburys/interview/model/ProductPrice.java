package uk.co.sainsburys.interview.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductPrice {
    @JsonProperty("product_uid")
    private String productUid;

    @JsonProperty("unit_price")
    private double unitPrice;

    @JsonProperty("unit_price_measure")
    private String unitPriceMeasure;

    @JsonProperty("unit_price_measure_amount")
    private int unitPriceMeasureAmount;

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
