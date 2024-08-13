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
        return unitPrice;
    }

    public void setPrice(double price) {
        this.unitPrice = price;
    }

    public String getMeasure() {
        return unitPriceMeasure;
    }

    public void setMeasure(String measure) {
        this.unitPriceMeasure = measure;
    }

    public int getMeasureAmount() {
        return unitPriceMeasureAmount;
    }

    public void setMeasureAmount(int measureAmount) {
        this.unitPriceMeasureAmount = measureAmount;
    }
}
