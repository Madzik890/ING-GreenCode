package com.ing.ing.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ATM implements Comparable<ATM> {
    private int region;
    private int atmId;

    public ATM(int region, int atmId) {
        setRegion(region);
        setAtmId(atmId);
    }

    @JsonProperty("region")
    public final void setRegion(int region) {
        if(region < 1 || region > 9999) throw new IllegalArgumentException("Bad region id");
        this.region = region;
    }
    @JsonProperty("atmId")
    public final void setAtmId(int atmId) {
        if(atmId < 1 || atmId > 9999) throw new IllegalArgumentException("Bad atm id");
        this.atmId = atmId;
    }

    public final int getRegion() {
        return region;
    }
    public final int getAtmId() {
        return atmId;
    }

    @Override
    public final int compareTo(ATM atm) {
        var diffRegion = this.region - atm.region;
        if(diffRegion != 0) return diffRegion;
        return atmId - atm.atmId;
    }
}
