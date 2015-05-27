import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by paulbaker on 5/27/15.
 */
public class Globals {
    public static void main(String[] args) throws URISyntaxException, IOException {
        /*
        Here is how to use globals
         */
        Desktop.getDesktop().browse(new URI("http://bfy.tw/1vX"));
        /*
        While that was something of a joke, there is some seriousness to this point.
        Global variables are a problem. They hold a state that can be modified by anyone.
        This is a problem in object oriented programming because state can no longer be
        controlled (it is modifiable by anyone at any time), hence why we use encapsulation.

        Can these things be replaced with singletons? Yes. Yes they can, but even though they
        can, doesn't mean anyone uses the singleton anti-pattern very much anymore. Spring.IO
        is the big java framework flavor of right now and has been for the last couple years,
        because it uses dependency injection instead. There are service locator patterns as
        well, which is primarily what our current solutions are built on.

        Most people don't use globals or singletons (or shouldn't), which means that
        just because the language has it as part of it's syntax and specification; it
        isn't necessarily a good thing.

        Sources:
        http://stackoverflow.com/a/485020/1478636
        http://programmers.stackexchange.com/a/148109
         */
    }
}
