package com.github.nitf.umimamoru.server;

import androidx.annotation.Nullable;

public class StatusInfo {

    private String region;

    public StatusInfo(String region) {
        this.region = region;
    }

    public String getBeachName() {
        return "";
    }

    @Nullable
    public String[] getOccurPlace() {
        return null;
    }

    public int getWaveSpeed(int pole) {
        return 0;
    }

    public int getCountOccur() {
        return 0;
    }
}
