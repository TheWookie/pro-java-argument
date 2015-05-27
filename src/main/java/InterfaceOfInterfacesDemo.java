import java.util.LinkedList;
import java.util.List;

/**
 * Created by paulbaker on 5/27/15.
 */
public class InterfaceOfInterfacesDemo {

    public static void main(String[] args) {
        /*
        With this one, you only specify the concrete type once you get there with initialization.
         */
        List<List<Integer>> listOfLists = new LinkedList<List<Integer>>();
        for (int i = 1; i <= 10; i++) {
            LinkedList<Integer> innerList = new LinkedList<Integer>();
            listOfLists.add(innerList);
            for (int j = 1; j <= 5; j++) {
                innerList.add(i * j);
            }
        }
        /*
        Print everything out as proof things still work
         */
        for (List<Integer> innerList : listOfLists) {
            for (Integer item : innerList) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }
}
