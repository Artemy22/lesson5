/*
"5. Hide all the field and methods which allow to change the inner state of the class(Encapsulation).
 */
public class Lesson58 {
    public static void main(String[] args) {

    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;

        private Cat(String name, int age, int weight) {
            this.name = name;
            this.age = age;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        private void setAge(int age) {
            this.age = age;
        }
    }
}