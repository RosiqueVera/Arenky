package com.example.arenky;

import com.google.gson.annotations.SerializedName;

public class PopularRoutes {

    private boolean success;
    private String error;
    private String currency;

    public boolean getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public String getCurrency() {
        return currency;
    }
}
