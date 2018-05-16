package br.com.munieri.banco.horas.file;

import br.com.munieri.banco.horas.entity.Config;
import br.com.munieri.banco.horas.entity.TimeClockEntries;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;

public class Reade {

    public Config config() {
        return this.config(FileProperties.PATH + FileProperties.CONFIG_JSON);
    }

    public Config config(String fileName) {
        Gson gson = getGsonBuilder();
        JsonReader reader = getJsonReader(fileName);
        Config config = gson.fromJson(reader, Config.class);

        return config;
    }

    public List<TimeClockEntries> entries() {
        return this.entries(FileProperties.PATH + FileProperties.TIMECLOCK_ENTRIES_JSON);
    }

    public List<TimeClockEntries> entries(String fileName) {
        Gson gson = getGsonBuilder();
        JsonReader reader = getJsonReader(fileName);

        Type listType = new TypeToken<List<TimeClockEntries>>() {
        }.getType();
        List<TimeClockEntries> entries = gson.fromJson(reader, listType);

        return entries;
    }

    private JsonReader getJsonReader(String fileName) {
        JsonReader reader = null;
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            reader = new JsonReader(new FileReader(classLoader.getResource(fileName).getFile()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return reader;
    }

    private Gson getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                LocalDateTime.parse(json.getAsJsonPrimitive().getAsString())).create();
    }
}
