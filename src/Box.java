/**
 * Created by tanyi on 16/8/24.
 */
public class Box<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public <U extends Number> void inspect(U u) {
        System.out.println("T:" + t.getClass().getName());
        System.out.println("U:" + u.getClass().getName());
    }

    public static void main(String [] args) {
        Box<String> integerBox = new Box<>();
        integerBox.set("abc");
//        integerBox.inspect("abc");
        integerBox.inspect(new Integer(10));
    }

}
