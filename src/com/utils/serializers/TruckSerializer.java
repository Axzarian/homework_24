package com.utils.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.models.*;

import java.lang.reflect.Type;

public class TruckSerializer implements JsonSerializer<Truck> {
    @Override
    public JsonElement serialize(Truck truck, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject state = new JsonObject();
        JsonObject element = new JsonObject();


        element.addProperty("id", truck.getId());
        element.addProperty("name", truck.getName());
        element.addProperty("driver", truck.getDriver());
        state.add("state", state);


        return element;
    }
}
