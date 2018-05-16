package br.com.munieri.banco.horas.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Config {

    @SerializedName("period_start")
    private Date periodStart;
    @SerializedName("today")
    private Date today;
    @SerializedName("employees")
    private List<Employee> employees;

    public Date getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(Date periodStart) {
        this.periodStart = periodStart;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
