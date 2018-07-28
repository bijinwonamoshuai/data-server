package com.deepthink.scdata.model;

public class ActionTimeSummary {
    private Float time;
    private Integer state;

    @Override
    public String toString() {
        return "ActionTimeSummary{" +
                "time=" + time +
                ", state=" + state +
                '}';
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
