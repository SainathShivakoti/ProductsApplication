package uk.co.sainsburys.interview.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {

    @JsonProperty("product_uid")
    private String productUid;

    @JsonProperty("product_type")
    private String productType;

    @JsonProperty("name")
    private String name;

    @JsonProperty("full_url")
    private String fullUrl;

    @JsonProperty("unit_price")
    private double unitPrice;

    @JsonProperty("unit_price_measure")
    private String unitPriceMeasure;

    @JsonProperty("unit_price_measure_amount")
    private int unitPriceMeasureAmount;

    // Getters and setters
    public String getProductUid() {
        return productUid;
    }

    public void setProductUid(String productUid) {
        this.productUid = productUid;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnitPriceMeasure() {
        return unitPriceMeasure;
    }

    public void setUnitPriceMeasure(String unitPriceMeasure) {
        this.unitPriceMeasure = unitPriceMeasure;
    }

    public int getUnitPriceMeasureAmount() {
        return unitPriceMeasureAmount;
    }

    public void setUnitPriceMeasureAmount(int unitPriceMeasureAmount) {
        this.unitPriceMeasureAmount = unitPriceMeasureAmount;
    }
}
