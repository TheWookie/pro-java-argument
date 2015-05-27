/**
 * Created by paulbaker on 5/27/15.
 */
public class AutoCastDemo {

    public static void takeLong(long number) {
        System.out.println(number);
    }

    public static void main(String[] args) {
        takeLong(0);
        takeLong(new Integer(0));
        final int aDefiniteInteger = 0;
        takeLong(aDefiniteInteger);
    }
}
