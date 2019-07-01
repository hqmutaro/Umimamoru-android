package com.github.nitf.umimamoru.server;

import androidx.annotation.Nullable;

public class StatusInfo {

    private String beach;

    public StatusInfo(String beach) {
        this.beach = beach;
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
