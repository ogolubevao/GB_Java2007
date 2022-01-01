package lesson_1_3;

import java.util.Arrays;

public class HomeWorkApp_1_3 {
    public static void main(String[] args) {
        //Задание №1
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else if (array[i] == 0) {
                array[i] = 1;
            }
        }
        System.out.println("#1");
        System.out.println(Arrays.toString(array));
        System.out.println();

        //Задание №2
        int[] array2 = new int[100];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = i + 1;
        }
        System.out.println("#2");
        System.out.println(Arrays.toString(array2));
        System.out.println();

        //Задание №3
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        System.out.println("#3");
        System.out.println(Arrays.toString(array3));
        System.out.println();

        //Задание №4
        int[][] array4 = new int[5][5];
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4[i].length; j++) {
                if (i == j || (i + j) == (array4.length - 1)) {
                    array4[i][j] = 1;
                }
            }
        }
        System.out.println("#4");
        for (int i = 0; i < array4.length; i++) {
            System.out.println(Arrays.toString(array4[i]));
        }
        System.out.println();

        //Проверка задания №5
        System.out.println("#5");
        System.out.println(Arrays.toString(returnArray(5, 9)));
        System.out.println();

        //Задание №6
        int[] array6 = {100, 5, 3, 2, 11, 4, 5, -89, 4, 8, 9, 1};
        //int minValue = array6[0];
        int minValue = Integer.MAX_VALUE;
        //int maxValue = array6[0];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < array6.length; i++) {
            if (array6[i] < minValue) {
                minValue = array6[i];
            }
            if (array6[i] > maxValue) {
                maxValue = array6[i];
            }
        }
        System.out.println("#6");
        System.out.println("minValue = " + minValue + "  maxValue = " + maxValue);
        System.out.println();

        //Проверка задания №7
        System.out.println("#7");
        int[] array7 = {1, 5, 3, 3};
        System.out.println(Arrays.toString(array7));
        System.out.println(isHaveEqualParts(array7));
        System.out.println();

        //Проверка задания №8
        System.out.println("#8");
        int[] array8 = {1, 5, 47, 1, -98, 0, -7};
        System.out.println(Arrays.toString(array8));
        System.out.println(Arrays.toString(getShiftedArray(array8,1)));
        System.out.println();
    }

    //Реализация задания №5
    public static int[] returnArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    //Реализация задания №7
    public static boolean isHaveEqualParts(int[] arr) {
        int sumLeft;
        int sumRight;
        int count = 0;


        //Проверка на пустой массив
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        if (count == arr.length) {
            System.out.println("Массив должен быть не пустой");
            return false;
        }

        //Нахождение сумм правой и левой части массива и их сравнение
        for (int i = 0; i < arr.length - 1; i++) {
            sumLeft = 0;
            sumRight = 0;
            for (int iLeft = i; iLeft >= 0; iLeft--) {
                sumLeft += arr[iLeft];
            }
            for (int iRight = i + 1; iRight < arr.length; iRight++) {
                sumRight += arr[iRight];
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    //Реализация задания №8
    public static int[] getShiftedArray(int[] arr, int n) {

        //Проверка на массив из 1 значения. Его сдвигать не надо
        if (arr.length == 1) {
            return arr;
        }

        //Смещение массива на 1 символ через буферную int переменную,
        // повтор смещения через рекурсию, если n > 0
        if (n > 0) {
            int buffer = arr[0];
            arr[0] = arr[arr.length - 1];
            for (int i = arr.length - 2; i >= 1; i--) {
                arr[i + 1] = arr[i];
            }
            arr[1] = buffer;
            return getShiftedArray(arr, n - 1);
        } else {
            return arr;
        }
    }
}
