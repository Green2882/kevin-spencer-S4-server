package com.keyin.city;

public class City {
    private String id;
    private String name;
    private String state;
    private int population;

    public City(String id, String name, String state, int population) {
        this.id = id;
        this.name = name;
        this.state = state;
        this.population = population;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", population=" + population +
                '}';
    }
}

