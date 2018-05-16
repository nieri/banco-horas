package br.com.munieri.banco.horas.entity;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {

    @SerializedName("pis_number")
    private Long pisNumber;

    @SerializedName("name")
    private String name;

    @SerializedName("workload")
    private List<Workload> workloadList;

    private Map<LocalDate, Integer> horasTrabalhadas;

    public Long getPisNumber() {
        return pisNumber;
    }

    public void setPisNumber(Long pisNumber) {
        this.pisNumber = pisNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Workload> getWorkloadList() {
        return workloadList;
    }

    public void setWorkloadList(List<Workload> workloadList) {
        this.workloadList = workloadList;
    }

    public Map<LocalDate, Integer> getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Map<LocalDate, Integer> horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Map<LocalDate, Integer> getSaldoHorasPorDia() {

        int saldoDiario;
        int workLoadInMinutes = workloadList.get(0).getWorkLoadInMinutes();

        Map<LocalDate, Integer> saldoPorDia = new HashMap<>();
        for (Map.Entry<LocalDate, Integer> workTimeInMinutes : horasTrabalhadas.entrySet()) {
            int workTime = workTimeInMinutes.getValue();
            saldoDiario = workTime - workLoadInMinutes;
            saldoPorDia.put(workTimeInMinutes.getKey(), saldoDiario);
        }

        return saldoPorDia;
    }
}
