import java.util.List;

/**
 * Created by paulbaker on 5/27/15.
 */
public class ErasureDemo {

    /*
     With these two sample methods, you will get type erasure which is a compiler error.
      */
//    public static void method(List<String> list) {
//
//    }
//
//    public static void method(List<Integer> list){
//
//    }

    /*
    Why not simply use generic in a way that generics are used best?
     */
    public static <T> void method(List<T> list) {
        for (T item : list) {
            System.out.println(item.toString());
        }
    }

    public static void main(String[] args) {
        method(PseudoListInitializer.AsArrayList(1, 2, 3, 4, 5, 6));
        method(PseudoListInitializer.AsArrayList('a', 'b', 'c', 'd', 'e'));
    }
}
