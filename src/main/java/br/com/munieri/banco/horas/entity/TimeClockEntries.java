package br.com.munieri.banco.horas.entity;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TimeClockEntries {

    @SerializedName("pis_number")
    private Long pisNumber;

    @SerializedName("entries")
    private List<LocalDateTime> entries;

    public Long getPisNumber() {
        return pisNumber;
    }

    public void setPisNumber(Long pisNumber) {
        this.pisNumber = pisNumber;
    }

    public List<LocalDateTime> getEntries() {
        return entries;
    }

    public void setEntries(List<LocalDateTime> entries) {
        this.entries = entries;
    }

    public Map<LocalDate, Integer> getSomatoriaHorasPorDia() {

        Map<LocalDate, List<LocalTime>> workedTime = entries.stream()
                .collect(Collectors.groupingBy(LocalDateTime::toLocalDate,
                        Collectors.mapping(LocalDateTime::toLocalTime, Collectors.toList())
                        )
                );

        Map<LocalDate, Integer> retorno = new HashMap<>();
        for (Map.Entry<LocalDate, List<LocalTime>> entry : workedTime.entrySet()) {
            List<LocalTime> localTimeList = entry.getValue();
            Map<Boolean, List<LocalTime>> collect = localTimeList.stream().collect(Collectors.groupingBy(
                    o -> o.equals(LocalTime.NOON) || o.isBefore(LocalTime.NOON)));
            int resultado = 0;
            for (List<LocalTime> localTimes : collect.values()) {
                resultado += ((localTimes.stream().map(localTime -> localTime.toSecondOfDay())
                        .reduce((integer, integer2) -> integer2 - integer).orElse(0) / 60));
            }
            retorno.put(entry.getKey(), resultado);
        }
        return retorno;
    }
}
