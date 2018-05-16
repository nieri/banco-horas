package br.com.munieri.banco.horas.entity;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeTest {

    @Test
    public void deve_retornar_saldo_diario_zero() {

        Map<LocalDate, Integer> saldoHorasMock = new HashMap<>();
        saldoHorasMock.put(LocalDate.of(2018, 5, 01), 0);

        TimeClockEntries timeClockEntries = new TimeClockEntries();
        timeClockEntries.setEntries(mockEntriesSaldoZero());

        Employee employee = new Employee();
        employee.setWorkloadList(Arrays.asList(mockWorkload()));
        employee.setHorasTrabalhadas(timeClockEntries.getSomatoriaHorasPorDia());

        Assert.assertEquals(employee.getSaldoHorasPorDia(), saldoHorasMock);
    }

    @Test
    public void deve_retornar_saldo_diario_dez() {

        Map<LocalDate, Integer> saldoHorasMock = new HashMap<>();
        saldoHorasMock.put(LocalDate.of(2018, 5, 01), 10);

        TimeClockEntries timeClockEntries = new TimeClockEntries();
        timeClockEntries.setEntries(mockEntriesSaldoDez());

        Employee employee = new Employee();
        employee.setWorkloadList(Arrays.asList(mockWorkload()));
        employee.setHorasTrabalhadas(timeClockEntries.getSomatoriaHorasPorDia());

        Assert.assertEquals(employee.getSaldoHorasPorDia(), saldoHorasMock);
    }

    @Test
    public void deve_retornar_saldo_diario_negativo_dez() {

        Map<LocalDate, Integer> saldoHorasMock = new HashMap<>();
        saldoHorasMock.put(LocalDate.of(2018, 5, 01), -10);

        TimeClockEntries timeClockEntries = new TimeClockEntries();
        timeClockEntries.setEntries(mockEntriesSaldoNegativoDez());

        Employee employee = new Employee();
        employee.setWorkloadList(Arrays.asList(mockWorkload()));
        employee.setHorasTrabalhadas(timeClockEntries.getSomatoriaHorasPorDia());

        Assert.assertEquals(employee.getSaldoHorasPorDia(), saldoHorasMock);
    }


    private Workload mockWorkload() {
        Workload workload = new Workload();
        workload.setMinimumRestIntervalInMinutes(15);
        workload.setWorkLoadInMinutes(480);
        workload.setDays(Arrays.asList("mon","tue","wed","thu"));
        return workload;
    }

    private List<LocalDateTime> mockEntriesSaldoZero() {
        return Arrays.asList(LocalDateTime.of(2018, 5, 01, 8, 00),
                    LocalDateTime.of(2018, 5, 01, 12, 00),
                    LocalDateTime.of(2018, 5, 01, 13, 00),
                    LocalDateTime.of(2018, 5, 01, 17, 00));
    }

    private List<LocalDateTime> mockEntriesSaldoDez() {
        return Arrays.asList(LocalDateTime.of(2018, 5, 01, 8, 00),
                LocalDateTime.of(2018, 5, 01, 12, 00),
                LocalDateTime.of(2018, 5, 01, 13, 00),
                LocalDateTime.of(2018, 5, 01, 17, 10));
    }

    private List<LocalDateTime> mockEntriesSaldoNegativoDez() {
        return Arrays.asList(LocalDateTime.of(2018, 5, 01, 8, 00),
                LocalDateTime.of(2018, 5, 01, 12, 00),
                LocalDateTime.of(2018, 5, 01, 13, 00),
                LocalDateTime.of(2018, 5, 01, 16, 50));
    }
}
