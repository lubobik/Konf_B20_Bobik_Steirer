package at.fhj.iit.custom;

public class Operator {
    private final String firstName;
    private final String lastName;

    public Operator(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
