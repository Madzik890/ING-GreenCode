package com.ing.ing.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public final class Task extends ATM {
    public enum RequestType {
        FAILURE_RESTART(true),
        PRIORITY(true),
        SIGNAL_LOW(false),
        STANDARD(false);

        RequestType(boolean value) {
        }

    }
    private RequestType requestType;

    public Task(int region, RequestType requestType, int atmId) {
        super(region, atmId);
        setRequestType(requestType);
    }

    @JsonProperty("requestType")
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    @JsonIgnore
    public RequestType getRequestType() {
        return requestType;
    }

    @Override
    public boolean equals(Object obj) { return getAtmId() == ((Task)obj).getAtmId(); }
    @Override
    public int hashCode() { return this.getAtmId() + this.getRegion(); }
}

