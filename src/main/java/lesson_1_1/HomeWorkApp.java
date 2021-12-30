package lesson_1_1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange\n" + "Banana\n" + "Apple\n");
    }

    public static void checkSumSign() {
        int a = -20;
        int b = 20;
        if (a+b>=0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        int value = -10;
        if(value>100) {
            System.out.println("Зелёный");
        } else if (value <= 0) {
            System.out.println("Красный");
        } else {
            System.out.println("Жёлтый");
        }
    }

    public static void compareNumbers() {
        int a = 40;
        int b = 30;
        if(a>=b) {
            System.out.println("a>=b");
        } else {
            System.out.println("a<b");
        }
    }

}
