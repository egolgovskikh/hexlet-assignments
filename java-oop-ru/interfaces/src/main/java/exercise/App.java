package exercise;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int count) {
        return apartments.stream()
                .sorted(Comparator.comparingDouble(Home::getArea))
                .limit(count)
                .map(Object::toString)
                .toList();
    }
}
// END
