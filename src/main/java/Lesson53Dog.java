/*
"3. Create a class Dog.
The dog should have a name and an age (private).
Create getters and setter for all the fields."
*/

public class Lesson53Dog {
    private int age;
    private String name;

    public static void main(String[] args) {

        Lesson53Dog dog = new Lesson53Dog();
        dog.setName("2Zik");
        dog.setAge(1);
        if (dog.getAge() > 0 && dog.getName() != null)
            System.out.println("The name is " + dog.getName() + "\nThe age is " + dog.getAge());
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age > 0) this.age = age;
        else System.out.println("WRONG age");
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name != null) this.name = name;
        else System.out.println("WRONG name");
    }
}