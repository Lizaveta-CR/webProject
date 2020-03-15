package com.domain;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class Order {
    private int id;
//    @NotNull
    private String name;
//    @DecimalMin("0.00")
    private Double price;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
