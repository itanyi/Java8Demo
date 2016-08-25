
/**
 * Created by tanyi on 16/8/24.
 */

//@Hints({@Hint("hint1"), @Hint("hint2")})

@Hint("hint1")
@Hint("hint2")
public class Person {
    private String firstName;
    private String lastName;

    Person() {

    }

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }
}
