package br.com.munieri.banco.horas.entity;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeClockEntriesTest {

    @Test
    public void deve_retornar_somatoria_ok() {

        Map<LocalDate, Integer> mock = new HashMap<>();
        mock.put(LocalDate.of(2018, 5, 01), 480);

        List<LocalDateTime> entries = Arrays.asList(LocalDateTime.of(2018, 5, 01, 8, 00),
                LocalDateTime.of(2018, 5, 01, 12, 00),
                LocalDateTime.of(2018, 5, 01, 13, 00),
                LocalDateTime.of(2018, 5, 01, 17, 00));

        TimeClockEntries timeClockEntries = new TimeClockEntries();
        timeClockEntries.setEntries(entries);

        Map<LocalDate, Integer> somatoriaHorasPorDia = timeClockEntries.getSomatoriaHorasPorDia();

        int somatoria = somatoriaHorasPorDia.get(LocalDate.of(2018, 5, 01)).intValue();
        int somatoriaMock = mock.get(LocalDate.of(2018, 5, 01)).intValue();

        Assert.assertEquals(somatoria, somatoriaMock);
    }
}