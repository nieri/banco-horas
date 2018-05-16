package br.com.munieri.banco.horas.file;

import br.com.munieri.banco.horas.entity.Config;
import br.com.munieri.banco.horas.entity.Output;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

public class Write {

    public void json(Config config) {
        List<Output> output = config.getEmployees().stream().map(employee -> new Output(employee)).collect(Collectors.toList());
        try (java.io.Writer writer = new FileWriter(FileProperties.OUTPUT_PATH + FileProperties.OUTPUT_JSON)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(output, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
