package com.utils.deserialazers;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.models.Base;
import com.models.Repair;
import com.models.Run;
import com.models.State;

import java.lang.reflect.Type;

public class StateDeserializer implements JsonDeserializer<State> {
    @Override
    public State deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String data = jsonElement.getAsString();

        return switch (data.toLowerCase()){
            case "base" -> new Base();
            case "run" -> new Run();
            case "repair" -> new Repair();
            default -> null;
        };

    }
}
