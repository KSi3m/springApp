package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("unitPrice")
    private int unitPrice;
    @JsonProperty("quantity")
    private int quantity;

    public ProductDTO() {
    }

    public ProductDTO(String name, int unitPrice, int quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
