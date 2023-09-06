package com.example.artifact_app_collection;

public class Model {
    String url,id,name,description,contacts,price;

    public String getName() {
        return name;
    }

    public String getContacts() {
        return contacts;
    }

    public String getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Model(String id, String name, String description, String contacts, String price, String url) {
        this.url = url;
        this.id=id;
        this.name = name;
        this.description=description;
        this.contacts=contacts;
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
