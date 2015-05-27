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
        List<String> stringArrayList = AsArrayList("Hello", "My", "Name", "Is", "Sangye Dorje Konchok");
        List<String> stringLinkedList = AsLinkedList("It", "Is", "A", "Tibetan", "Name");
    }
}
