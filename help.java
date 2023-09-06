package com.example.artifact_app_collection;

public class help {
    String id,name,description,address,price;

    public help(String name, String description, String address, String price) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPrice() {
        return price;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
