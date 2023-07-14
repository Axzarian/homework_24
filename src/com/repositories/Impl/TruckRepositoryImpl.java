package com.repositories.Impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.models.State;
import com.models.Truck;
import com.repositories.TruckRepository;
import com.utils.deserialazers.StateDeserializer;
import com.utils.serializers.TruckSerializer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TruckRepositoryImpl implements TruckRepository {

    private final Gson gson;

    public TruckRepositoryImpl() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(State.class, new StateDeserializer())
                .registerTypeAdapter(Truck.class, new TruckSerializer())
                .setPrettyPrinting()
                .create();
    }


    @Override
    public Truck[] read(String path) {
        try(FileReader reader = new FileReader(path)){
            return gson.fromJson(reader, Truck[].class);

        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }catch (JsonIOException exception){
            throw new JsonIOException(exception);
        }

    }

    @Override
    public void write(String path, Truck[] trucks) {
        try (FileWriter writer = new FileWriter(path)){
            gson.toJson(trucks, writer);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
