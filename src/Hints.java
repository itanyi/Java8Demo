import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by tanyi on 16/8/25.
 */
@Retention(RetentionPolicy.RUNTIME)
@interface Hints {
    Hint[] value();
}
