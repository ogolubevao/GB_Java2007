package lesson_1_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class XOs {
    //Игровое поле
    public static char[][] map;

    //Размер поля
    public static final int SIZE = 5;

    //Точек для победы
    public static final int DOTS_TO_WIN = 3;

    //Описание точек
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';

    //Сканер
    public static final Scanner SCANNER = new Scanner(System.in);

    //Рандом
    public static final Random RANDOM = new Random();

    //Координаты точки для блокировки хода человека
    public static String[] aimArr;

    /**
     * Проинициализировать поле.
     */
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    /**
     * Печать игрового поля
     */
    public static void printMap() {
        System.out.print("   ");
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + "  ");
        }
        System.out.println();
        for (int i = 0; i < map.length; i++) {
            System.out.print(i + 1 + "  ");
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Ход человека
     */
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате: Х У");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    /**
     * Ход робота
     */
    public static void aiTurn() {
        int x, y;

        do {
            x = RANDOM.nextInt(SIZE);
            y = RANDOM.nextInt(SIZE);

        } while (!isCellValid(x, y));
        System.out.println("Робот делает ход в " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_0;
    }

    /**
     * проверка валидны ли значения координат
     *
     * @param x координата Х
     * @param y координата Н
     * @return да/нет
     */
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        if (map[y][x] != DOT_EMPTY) {
            return false;
        }
        return true;
    }

    /**
     * Проверка победы
     *
     * @param symbol Символ, для которого проверяем
     * @return true, если выиграл
     */
    public static boolean checkWin(char symbol) {
        //строки
        int count;
        for (int i = 0; i < map.length; i++) {
            count = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == symbol) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        //столбцы
        for (int i = 0; i < map.length; i++) {
            count = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[j][i] == symbol) {
                    count++;
                    if (count == DOTS_TO_WIN) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }

        //диагональ 1
        count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == j) {
                    if (map[i][j] == symbol) {
                        count++;
                        if (count == DOTS_TO_WIN) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }

        //диагональ 2
        count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if ((i + j) == (SIZE - 1)) {
                    if (map[i][j] == symbol) {
                        count++;
                        if (count == DOTS_TO_WIN) {
                            return true;
                        }
                    } else {
                        count = 0;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Проверка, что в поле не осталось ни одной ячейки
     *
     * @return true, если нет ни одной свободной
     */
    public static boolean isMapFull() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }

        }
        return true;
    }


    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Побеждает человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_0)) {
                System.out.println("Побеждает компьютер");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
        System.out.println("Game over");
    }
}
