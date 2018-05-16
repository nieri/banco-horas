package br.com.munieri.banco.horas.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    @SerializedName("pis_number")
    private Long pisNumber;

    @SerializedName("sumary")
    private Summary summary;

    private List<History> histories;

    public Output() {
    }

    public Output(Employee employee) {

        this.pisNumber = employee.getPisNumber();
        this.summary = getSummary(employee);
        this.histories = getHistories(employee);

    }

    private List<History> getHistories(Employee employee) {
        return employee.getSaldoHorasPorDia().entrySet().stream().
                map(dayOfWeekIntegerEntry -> new History(dayOfWeekIntegerEntry.getKey(), dayOfWeekIntegerEntry.getValue()))
                .collect(Collectors.toList());
    }

    private Summary getSummary(Employee employee) {
        return new Summary(employee.getHorasTrabalhadas().values()
                .stream().mapToInt(value -> value).sum());
    }

    public Long getPisNumber() {
        return pisNumber;
    }

    public void setPisNumber(Long pisNumber) {
        this.pisNumber = pisNumber;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<History> getHistories() {
        return histories;
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
    }
}
