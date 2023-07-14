package com.repositories;

import com.models.Truck;

public interface TruckRepository {
    Truck[] read(String path);
    void write(String path, Truck[] trucks);
}
