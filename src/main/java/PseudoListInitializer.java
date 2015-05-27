import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by paulbaker on 5/27/15.
 */
public class PseudoListInitializer {
    public static <T> ArrayList<T> AsArrayList(T... items) {
        ArrayList<T> list = new ArrayList<T>(items.length);
        for (int i = 0; i < items.length; i++) {
            list.add(i, items[i]);
        }
        return list;
    }

    public static <T> LinkedList<T> AsLinkedList(T... items) {
        LinkedList<T> list = new LinkedList<T>();
        for (int i = 0; i < items.length; i++) {
            list.addLast(items[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        /*
        Now, I see what you are going to say. "There is still overhead for creating these lists at runtime"
        We need to be honest with ourselves. This overhead is going to be fairly negligible and in either case
        the time for either a true literal OR our fake literal is going to computationally be O(N) regardless.

        While we're being honest, even if it were HORRIBLY inefficient to create list literals people would
        still do it because it is truly just syntactic sugar we're after.
         */
        List<String> stringArrayList = AsArrayList("It was", "the one", "armed", "man!");
        List<String> stringLinkedList = AsLinkedList("Do you", "remember", "the", "fugitive", "?");
        List<Integer> integerArrayList = AsArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }
}
