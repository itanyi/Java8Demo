import java.sql.Time;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * Created by tanyi on 16/8/25.
 */
public class TimeLoader<T> {

    private long intervalMs;

    private Supplier<T> supplier;

    private T value;

    private static ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1);

    public TimeLoader(long intervalMs, Supplier<T> supplier) {
        this.intervalMs = intervalMs;
        this.supplier = supplier;
    }

    private void scheduleNext(long intervalMs) {
        scheduledExecutorService.schedule(() -> {
            try {
                load();
            }catch (Exception e) {
                System.out.println(e);
            }finally {
                scheduleNext(intervalMs);
            }
        }, intervalMs, TimeUnit.MILLISECONDS);
    }

    private void load() {
        T tmp_value = supplier.get();
        if(tmp_value != null) {
            this.value = tmp_value;
        }
    }

    public T get() {
        return value;
    }

}
