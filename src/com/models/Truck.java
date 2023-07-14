package com.models;

public class Truck {
    private int id;
    private String name;
    private String driver;
    private State stateName;

    Truck(int id, String name, String driver, State stateName){
        this.id = id;
        this.name =name;
        this.driver = driver;
        this.stateName = stateName;
    }

    public void startRun(){
        stateName.startRun(this);
    }
    public void startRepair(){
        stateName.startRepair(this);
    }

    public void changeDriver(){

    }

    @Override
    public String toString() {
        String myString = String.format(" %d  |  %15s            |     %6s       |    %s   ", id, name, driver, stateName);
        return myString;
    }





    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
    public String getDriver() {
        return driver;
    }

    public void setStateName(State stateName) {
        this.stateName = stateName;
    }
    public State getStateName() {
        return stateName;
    }
}
