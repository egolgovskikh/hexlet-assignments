package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage keyValueStorage) {
        Map<String, String> mapCopy = new HashMap<>(keyValueStorage.toMap());
        mapCopy.forEach((k, v) -> {
            keyValueStorage.unset(k);
            keyValueStorage.set(v, k);
        });
    }
}
// END
