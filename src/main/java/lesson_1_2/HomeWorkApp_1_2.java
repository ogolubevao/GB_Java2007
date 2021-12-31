package lesson_1_2;

public class HomeWorkApp_1_2 {
    public static void main(String[] args) {
        //Проверки-вызовы:
        //#1
        System.out.println("#1");
        System.out.println(isSumFrom10To20(20, 20));
        System.out.println();

        //#2
        System.out.println("#2");
        printPositiveOrNegativeNum(-50);
        System.out.println();

        //#3
        System.out.println("#3");
        System.out.println(isNegative(0));
        System.out.println();

        //#4
        System.out.println("#4");
        printStringNTimes("Hello!", 2);
        System.out.println();

        //#5
        System.out.println("#5");
        System.out.println(isLeapYear(801));
    }

    //Реализация:
    //#1
    public static boolean isSumFrom10To20(int a, int b) {
        return a + b >= 10 && a + b <= 20;
    }

    //#2
    public static void printPositiveOrNegativeNum (int a) {
        if (a >= 0)
            System.out.println("Положительное число");
        else
            System.out.println("Отрицательное число");
    }

    //#3
    public static boolean isNegative(int a) {
        return a < 0;
    }

    //#4
    public static void printStringNTimes(String str, int n) {
        if (n <= 0) {
            System.out.println("Число должно быть больше ноля");
            return;
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(str);
        }
    }

    //#5
    public static boolean isLeapYear(int year) {
        if (year <= 0) {
            System.out.println("Число должно быть больше ноля");
            return false;
        }
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                System.out.println("Не високосный год");
                return false;
            } else {
                System.out.println("Високосный год");
                return true;
            }
        } else {
            System.out.println("Не високосный год");
            return false;
        }
    }
}
