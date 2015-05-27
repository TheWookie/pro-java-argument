/**
 * Created by paulbaker on 5/27/15.
 */
public class CircleOverloadedConstructorAndInnerClassDemo {

    private int radius;

    /**
     * Creates a unit circle (a circle with radius = 1)
     * <p>
     * https://en.wikipedia.org/wiki/Unit_circle
     */
    public CircleOverloadedConstructorAndInnerClassDemo() {
        this(1);
    }

    /**
     * Creates a circle with an arbitrary radius
     *
     * @param radius
     */
    public CircleOverloadedConstructorAndInnerClassDemo(int radius) {
        this.radius = radius;
    }

    public Coordinate coordinateAtTime(double time) {
        return new Coordinate(radius * Math.cos(time), radius * Math.sin(time));
    }

    /**
     * Inner classes seem fine?
     */
    public class Coordinate {
        private double x, y;

        private Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
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
