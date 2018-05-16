package br.com.munieri.banco.horas;

import br.com.munieri.banco.horas.entity.Config;
import br.com.munieri.banco.horas.entity.Employee;
import br.com.munieri.banco.horas.entity.TimeClockEntries;
import br.com.munieri.banco.horas.file.Copy;
import br.com.munieri.banco.horas.file.Create;
import br.com.munieri.banco.horas.file.Reade;
import br.com.munieri.banco.horas.file.Write;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Create create = new Create();
        create.path();
        Copy copy = new Copy();
        copy.files();

        Reade reade = new Reade();
        Config config = reade.config();
        List<TimeClockEntries> timeClockEntries = reade.entries();

        for (Employee employee : config.getEmployees()) {
            for (TimeClockEntries entry : timeClockEntries) {
                if (employee.getPisNumber().equals(entry.getPisNumber())) {
                    employee.setHorasTrabalhadas(entry.getSomatoriaHorasPorDia());
                }
            }
        }

        new Write().json(config);
        System.out.println("Arquivo salvo na pasta [\\banco-horas\\output]");
    }
}
