package br.com.munieri.banco.horas.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Workload {

    @SerializedName("workload_in_minutes")
    private int workLoadInMinutes;

    @SerializedName("minimum_rest_interval_in_minutes")
    private int minimumRestIntervalInMinutes;

    @SerializedName("days")
    private List<String> days;

    public int getWorkLoadInMinutes() {
        return workLoadInMinutes;
    }

    public void setWorkLoadInMinutes(int workLoadInMinutes) {
        this.workLoadInMinutes = workLoadInMinutes;
    }

    public int getMinimumRestIntervalInMinutes() {
        return minimumRestIntervalInMinutes;
    }

    public void setMinimumRestIntervalInMinutes(int minimumRestIntervalInMinutes) {
        this.minimumRestIntervalInMinutes = minimumRestIntervalInMinutes;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
}
