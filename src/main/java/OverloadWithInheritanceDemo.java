/**
 * Created by paulbaker on 5/25/15.
 */
public class OverloadWithInheritanceDemo {
    public static class FooBar {

    }

    public static class FooBaz extends FooBar {

    }

    public static void TakeObj(FooBar fooBar) {
        System.out.println("FooBar was taken");
    }

    public static void TakeObj(FooBaz fooBaz) {
        System.out.println("FooBaz was taken");
    }

    public static void main(String[] args) {
        /** In order to force java to use an overloaded method for a subclass, we must
         * type cast that item back to the subclass.
         */
        FooBar foobar = new FooBaz();
        TakeObj(foobar);
        TakeObj((FooBaz) foobar);
    }
}
