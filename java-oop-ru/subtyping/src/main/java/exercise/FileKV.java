package exercise;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {

    private final String filepath;

    public FileKV(String filepath, Map<String, String> map) {
        this.filepath = filepath;
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.write(Utils.serialize(map));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> mapKV = toMap();
        mapKV.put(key, value);
        new FileKV(filepath, mapKV);
    }

    @Override
    public void unset(String key) {
        Map<String, String> mapKV = toMap();
        mapKV.remove(key);
        new FileKV(filepath, mapKV);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> mapKV = toMap();
        return mapKV.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String jsonKV;
        try {
            jsonKV = Files.readString(Path.of(filepath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Utils.unserialize(jsonKV);
    }
}
// END
