package br.com.munieri.banco.horas.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Copy {

    public void files() {
        this.config();
        this.entries();
    }

    private void config() {
        this.copyFile(FileProperties.PATH + FileProperties.CONFIG_JSON, FileProperties.INPUT_PATH + FileProperties.CONFIG_JSON);
    }

    private void entries() {
        this.copyFile(FileProperties.PATH + FileProperties.TIMECLOCK_ENTRIES_JSON, FileProperties.INPUT_PATH + FileProperties.TIMECLOCK_ENTRIES_JSON);
    }

    private void copyFile(String origin, String destiny) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File original = new File(classLoader.getResource(origin).getFile());
        Path dest = Paths.get(destiny);

        try {
            Files.copy(new FileInputStream(original), dest, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
