/**
 * Created by paulbaker on 5/27/15.
 * <p>
 * There is a lot going on in this class. First off, it addresses the private members argument.
 * Why would you want any of these pre-calculated members to be publicly mutable? In the case
 * of a circle, they need to only be calculated once and then they can be retrieved.
 * If any of these members is changed without recalculating the others, then nothing can be
 * guaranteed to be the correct value.
 * <p>
 * This is why we use encapsulation.
 * <p>
 * This class also demonstrates how to use an overloaded constructor. The default constructor
 * creates a unit circle, but the over loaded constructor lets us set an arbitrary radius for
 * the circle
 */
public class Circle {

    private int radius, diameter;
    private double circumference, area;

    /**
     * Creates a unit circle (a circle with radius = 1)
     * <p>
     * https://en.wikipedia.org/wiki/Unit_circle
     */
    public Circle() {
        // This calls the other constructor
        this(1);
    }

    /**
     * Creates a circle with an arbitrary radius
     *
     * @param radius
     */
    public Circle(int radius) {
        // This calls a method that lets us change the radius arbitrarily.
        // This will not only set the radius in the constructor, but will
        // also let future users change the radius of a circle at their
        // whim.
        changeRadius(radius);
    }

    /**
     * Set the radius. (Performs calculations)
     *
     * @param radius
     */
    private void changeRadius(int radius) {
        this.radius = radius;
        diameter = 2 * radius;
        circumference = diameter * Math.PI;
        area = Math.pow(radius, 2) * Math.PI;
    }

    public CircleCoordinate coordinateAtTime(double time) {
        return new CircleCoordinate(time);
    }

    public int getRadius() {
        return radius;
    }

    public int getDiameter() {
        return diameter;
    }

    public double getCircumference() {
        return circumference;
    }

    public double getArea() {
        return area;
    }

    /**
     * Inner classes seem fine to me?
     */
    public class CircleCoordinate {
        private double x, y;

        private CircleCoordinate(double time) {
            x = radius * Math.cos(time);
            y = radius * Math.sin(time);
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        @Override
        public String toString() {
            return "(" + getX() + ", " + getY() + ")";
        }
    }
}
