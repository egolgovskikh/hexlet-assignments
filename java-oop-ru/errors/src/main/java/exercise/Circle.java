package exercise;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Getter
class Circle {

    private Point point;
    private int radius;

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException();
        }
        return Math.PI * radius * radius;
    }
}
// END
