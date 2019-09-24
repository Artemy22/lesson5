/*
"2. Implement the method fight() depending on weight, strength and age of the boxer:
You should write dependency by yourself. The method should return true or false if our boxer won or lost.
*/

public class Lesson52Boxer {
    private int age;
    private int weight;
    private int strength;

    private Lesson52Boxer(int age, int weight, int strength) {
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    private boolean fight(Lesson52Boxer anotherLesson52Boxer) {
        return this.strength > anotherLesson52Boxer.strength &&
                this.age < anotherLesson52Boxer.age &&
                this.weight < anotherLesson52Boxer.weight;
    }

    public static void main(String[] args) {
        Lesson52Boxer ourBoxer = new Lesson52Boxer(18, 78, 123);
        Lesson52Boxer newBoxer = new Lesson52Boxer(19, 84, 100);
        boolean check = ourBoxer.fight(newBoxer);
        System.out.println(check);
    }
}