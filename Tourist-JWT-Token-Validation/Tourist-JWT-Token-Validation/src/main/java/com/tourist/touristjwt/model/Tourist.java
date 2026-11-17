package com.tourist.touristjwt.model;

public class Tourist {
    private int id;
    private String name;
    private String destination;
    private String country;

    public Tourist() {
    }

    public Tourist(int id, String name, String destination, String country) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.country = country;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDestination() { return destination; }
    public String getCountry() { return country; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setCountry(String country) { this.country = country; }
}
