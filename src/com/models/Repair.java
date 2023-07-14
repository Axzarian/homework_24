package com.models;

import java.util.Random;

public class Repair implements State{
    private  static final Random random = new Random();
    @Override
    public void changeDriver(Truck truck) {
        System.out.println("Водитель был заменен ");

    }

    @Override
    public void startRun(Truck truck) {
        int dice = random.nextInt(10) + 1;
        if (dice < 6 ) {
            truck.setStateName(new Run());
            System.out.println("Грузовик в пути");
        }
        else {
            truck.setStateName(new Base());
            System.out.println("Грузовик вернулся на базу");

        }
    }

    @Override
    public void startRepair(Truck truck) {
        System.out.println("Грузовик уже в ремонте");
    }
    public String toString(){
        return  "repair";
    }
}
