public class testStringMix {

    public static void main(String[] args) {

        String first = "FIRST";
        System.out.println("\"first\" = " + first);
        String second = "SECOND";
        System.out.println("\"second\" = " + second);

        String[] firstArray = second.split("");
        String[] secondArray = first.split("");

        first = String.join("", firstArray);
        System.out.printf("\"first\" = %s%n", first);

        second = String.join("", secondArray);
        System.out.printf("\"second\" = %s%n", second);
    }
}
