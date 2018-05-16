package br.com.munieri.banco.horas.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Create {

    public void path() {
        this.inputPath();
        this.outputPath();
    }

    private void create(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Diretório [" + path + "] criado com sucesso");
        } else {
            System.out.println("O diretório [" + path + "] já existe");
        }
    }

    private void inputPath() {
        this.create(filePath(FileProperties.INPUT_PATH));
    }

    private void outputPath() {
        this.create(filePath(FileProperties.OUTPUT_PATH));
    }

    private Path filePath(String path) {
        return Paths.get(path);
    }
}
