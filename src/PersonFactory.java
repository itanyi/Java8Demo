/**
 * Created by tanyi on 16/8/24.
 */
public interface PersonFactory<P extends Person> {
    P create(String fistName, String lastName);
}
