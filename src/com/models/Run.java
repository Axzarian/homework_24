package com.models;

public class Run implements State{
    @Override
    public void changeDriver(Truck truck) {
        System.out.println("Водителя нельзя менять в пути");
    }

    @Override
    public void startRun(Truck truck) {
        System.out.println("Грузовик уже в пути");
    }

    @Override
    public void startRepair(Truck truck) {
        truck.setStateName(new Repair());
        System.out.println("Грузовик встал на ремонт");
    }
    public String toString(){
        return  "run";
    }
}
