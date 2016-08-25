import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by tanyi on 16/8/25.it
 */
public class MapTimeReloader<K, R> extends TimeLoader<Map<K, R>>{
    public MapTimeReloader(long intervalMs, Function<R, K> keyGenerator, Supplier<Collection<R>> supplier) {
        super(intervalMs, () -> supplier.get().stream().collect(Collectors.toMap(keyGenerator, r->r)));
    }
}
