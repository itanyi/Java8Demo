/**
 * Created by tanyi on 16/8/25.
 */

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(Hints.class)
@Retention(RetentionPolicy.RUNTIME)
@interface Hint {
    String value();
}
