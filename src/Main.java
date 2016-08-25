import java.util.function.Function;

/**
 * Created by tanyi on 16/8/24.
 */
public class Main {

    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("tan", "yi");
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("123"));
    }
}
