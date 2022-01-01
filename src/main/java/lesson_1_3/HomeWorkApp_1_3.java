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


    }

    //Реализация задания №5
    public static int[] returnArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }


}
