package com.aca_disqo_generactive.controller.dto;

import com.aca_disqo_generactive.utils.Resolution;

public class ItemDTO {

    private int id;
    private int price;
    private String currency;
    private int groupId;
    private int itemType;
    private double finalPrice;
    private Resolution resolution;

    public ItemDTO() {
    }

    public ItemDTO(int id, int price, String currency, int groupId, int itemType) {
        this.id = id;
        this.price = price;
        this.currency = currency;
        this.groupId = groupId;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", groupId=" + groupId +
                ", finalPrice=" + finalPrice +
                '}';
    }
}
