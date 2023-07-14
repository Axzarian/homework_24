package com.context;


public enum ApplicationConstants {
    REQUEST_PATH("resources/data/request.json"),
    RESPONSE_PATH("resources/data/response.json");


    private final String value;

    ApplicationConstants(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
