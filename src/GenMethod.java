import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by tanyi on 16/8/24.
 */
public class GenMethod {
    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for(T t: a) {
            c.add(t);
        }
    }

    public  static void main(String [] args) {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<>();
        GenMethod.<Object>fromArrayToCollection(oa, co);
    }
}
