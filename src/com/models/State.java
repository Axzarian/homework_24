package com.models;

public interface State {
    void changeDriver(Truck truck);
    void startRun(Truck truck);
    void startRepair(Truck truck);

    
}
