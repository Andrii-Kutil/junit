package junit;

public class User {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(Object age) throws IllegalArgumentException {
        try {
            this.age = (int) age;
        } catch (Exception e) {
            throw new IllegalArgumentException("Age must be an Integer.");
        }
    }
}
