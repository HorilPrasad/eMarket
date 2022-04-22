package com.coolascode.emarket.modal;

public class Shops {

    private String shopName;
    private String shopType;
    private String shopLocation;
    private String shopImageUrl;

    public Shops() {
    }

    public Shops(String shopName, String shopType, String shopLocation, String shopImageUrl) {
        this.shopName = shopName;
        this.shopType = shopType;
        this.shopLocation = shopLocation;
        this.shopImageUrl = shopImageUrl;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopType() {
        return shopType;
    }

    public void setShopType(String shopType) {
        this.shopType = shopType;
    }

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }

    public String getShopImageUrl() {
        return shopImageUrl;
    }

    public void setShopImageUrl(String shopImageUrl) {
        this.shopImageUrl = shopImageUrl;
    }
}
