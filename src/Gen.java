/**
 * Created by tanyi on 16/8/24.
 */
public class Gen<T> {

    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        Gen<String> gen = new Gen<>();
        gen.setObj("abc");
        String str = gen.getObj();
        System.out.println(str);
        Gen gen2 = new Gen();
        gen2.setObj("abc");
        gen2.setObj(10);
        Integer num = (Integer) gen2.getObj();
        System.out.println(num);
    }
}
