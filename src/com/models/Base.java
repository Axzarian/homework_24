package com.models;

public class Base implements State{
    @Override
    public void changeDriver(Truck truck) {
        System.out.println("Водитель успешно поменян");
    }

    @Override
    public void startRun(Truck truck) {
        truck.setStateName(new Run());
        System.out.println("Грузовик вышел на маршрут");
    }

    @Override
    public void startRepair(Truck truck) {
        truck.setStateName(new Repair());
        System.out.println("Грузовик на ремонте");

    }

    public String toString(){
        return  "base";
    }
}
