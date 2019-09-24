// "1. Create a class ""Human"".
// A human should have the following attributes:
// weight, age, first name, last name, height."

public class Lesson51 {

    private int weight;
    private int age;
    private String firstName;
    private String lastName;
    private int height;

    public Lesson51(int weight, int age, String firstName, String lastName, int height) {
        this.weight = weight;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
    }

    public static void main(String[] args) {
        Lesson51 human = new Lesson51(123, 98, "Innokentiy", "Smoktunovsky", 217);

        System.out.println("First name is " + human.firstName);
        System.out.println("Last name is " + human.lastName);
        System.out.println("Age: " + human.age);
        System.out.println("Weight: " + human.weight);
        System.out.println("Height: " + human.height);
    }
}