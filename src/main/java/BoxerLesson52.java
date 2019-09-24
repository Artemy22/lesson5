/*
"2. Implement the method fight() depending on weight, strength and age of the boxer:
You should write dependency by yourself. The method should return true or false if our boxer won or lost.
*/

import java.util.Arrays;

public class BoxerLesson52 {
    private int age;
    private int weight;
    private int strength;

    private BoxerLesson52(int age, int weight, int strength) {
        this.age = age;
        this.weight = weight;
        this.strength = strength;
    }

    private boolean fight(BoxerLesson52 anotherBoxerLesson52) {
        return this.strength > anotherBoxerLesson52.strength &&
                this.age < anotherBoxerLesson52.age &&
                this.weight < anotherBoxerLesson52.weight;
    }

    public static void main(String[] args) {
        BoxerLesson52 ourBoxer = new BoxerLesson52(18, 78, 123);
        BoxerLesson52 newBoxer = new BoxerLesson52(19, 84, 100);
        boolean check = ourBoxer.fight(newBoxer);
        System.out.println(check);
    }
}