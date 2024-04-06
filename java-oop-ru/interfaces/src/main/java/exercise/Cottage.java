package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
class Cottage implements Home{

    private double area;
    private int floorCount;

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (getArea() > another.getArea()) {
            return 1;
        }
        if (getArea() < another.getArea()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + getArea() + " метров";
    }
}
// END
