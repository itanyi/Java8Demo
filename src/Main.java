import com.sun.xml.internal.stream.Entity;

import java.security.cert.PKIXRevocationChecker;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.sun.xml.internal.org.jvnet.fastinfoset.EncodingAlgorithmIndexes.UUID;

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
        Supplier<Person> personSupplier = Person::new;
        Person p = personSupplier.get();
        p.setFirstName("tan");
        System.out.println(p.getFirstName());
        Consumer<Person> greeter = (ps) -> System.out.println("Hello " + ps.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));

        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "WonderLand");

        comparator.compare(p1, p2);
        comparator.reversed().compare(p1, p2);

        Optional<String> optional = Optional.of("bam");

        System.out.println(optional.isPresent());
        optional.get();
        optional.orElse("fallback");

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));


        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("add1");
        stringCollection.add("add2");
        stringCollection.add("add3");
        stringCollection.add("dd");
        stringCollection.add("add5");
        stringCollection.add("bb");
        stringCollection.add("ccc");
        stringCollection.add("add8");
        stringCollection.add("eee");
        stringCollection.add("add10");

        stringCollection.stream().sorted().filter(s->s.startsWith("a")).forEach(System.out::println);

        stringCollection.stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
        boolean anyStartWith =
                stringCollection
                        .stream()
                .anyMatch(s -> s.startsWith("a"));
        System.out.println(anyStartWith);

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch(s -> s.startsWith("a"));
        System.out.println(allStartsWithA);

        boolean noneStartWithA =
                stringCollection.stream()
                        .noneMatch(s->s.startsWith("a"));
        System.out.println(noneStartWithA);

        long startWithB = stringCollection.stream().filter(s->s.startsWith("b")).count();
        System.out.println(startWithB);

        Optional<String> reduced =
                stringCollection
                        .stream().sorted().reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);

//        int max = 1000000;
//
//        List<Double> values = new ArrayList<>(max);
//
//        for(int i = 0; i < max; ++ i) {
//            values.add(Double.valueOf(Math.random() * 10000000.0));
//        }
//
//        long t0 = System.nanoTime();
//
//        long count = values.stream().sorted().count();
//
//        System.out.println(count);
//
//        long t1 = System.nanoTime();
//
//        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//
//        System.out.println(String.format("sequential sort took: %d ms", millis));
//
//        long t2 = System.nanoTime();
//
//        long count1 = values.parallelStream().sorted().count();
//        System.out.println(count1);
//
//        long t3 = System.nanoTime();
//
//        long millis1 = TimeUnit.NANOSECONDS.toMillis(t3 - t2);
//        System.out.println(String.format("parallel sort took: %d ms", millis1));

        Map<Integer, String> map = new HashMap<>();
        for(int i = 0; i < 10; ++i) {
            map.put(i, "val " + i);
        }

        map.forEach((id, val) -> System.out.println(val));

         Hint hint = Person.class.getAnnotation(Hint.class);
        System.out.println(hint);

        Hints hints1 = Person.class.getAnnotation(Hints.class);
        System.out.println(hints1);

        Hint[] hints2 = Person.class.getAnnotationsByType(Hint.class);
        System.out.println(hints2.length);
    }
}
