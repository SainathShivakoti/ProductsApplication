package uk.co.sainsburys.interview.model;

public class Product {
    private String productUid;
    private String productType;
    private String name;
    private String fullUrl;
    private double unitPrice;
    private String unitPriceMeasure;
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
