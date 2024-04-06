package exercise;

import lombok.AllArgsConstructor;

// BEGIN
@AllArgsConstructor
class Flat implements Home {

    private double area;
    private double balconyArea;
    private int floor;

    @Override
    public double getArea() {
        return area + balconyArea;
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
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }
}
// END
