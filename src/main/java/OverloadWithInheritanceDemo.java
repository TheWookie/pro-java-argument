import java.util.List;

/**
 * Created by paulbaker on 5/25/15.
 */
public class OverloadWithInheritanceDemo {
    public static class FooBar {
        public String aMethod() {
            return "I am a FooBar";
        }
    }

    public static class FooBaz extends FooBar {
        @Override
        public String aMethod() {
            return super.aMethod() + ", but I am also a FooBaz";
        }

        public void uniqueMethod() {
            System.out.println("This method is not in FooBar!");
        }
    }

    public static void TakeObj(FooBar fooBar) {
        System.out.println("TakeObj(FooBar) was called.");
    }

    public static void TakeObj(FooBaz fooBaz) {
        System.out.println("TakeObj(FooBaz) was called.");
        fooBaz.uniqueMethod();
    }

    public static void main(String[] args) {
        /**
         * In order to force java to use an overloaded method for a subclass, we must
         * type cast that item back to the subclass.
         */
        FooBar foobar = new FooBaz();
        TakeObj(foobar);
        TakeObj((FooBaz) foobar);
        /**
         * The knee jerk reaction to this is probably "that is stupid! why would we
         * ever want to HAVE to do that??"
         *
         * This question even in itself makes me wonder, why would we want to force
         * a consumer method to perform the functionality of an object? It seems
         * contrary to why we utilize polymorphism in the first place, does it not?
         *
         * If one were to have an abstract class "Employee" and two subclasses named
         * "HourlyEmployee" and "SalariedEmployee", should we write a distinct
         * consumer for each individual possibility? What about future implementations
         * such as "CommissionedEmployee" or other things that were not imagined at
         * the original time of implementation?
         *
         * Writing an individual method for each potentiality of an object is impractical
         * and self defeating. Just let polymorphism do its thing, that's the point OOP.
         */
        List<FooBar> fooBarList = PseudoListInitializer.AsArrayList(new FooBar(), new FooBar(), new FooBaz());
        for (FooBar fooBar : fooBarList) {
            System.out.println(fooBar.aMethod());
        }
    }
}
