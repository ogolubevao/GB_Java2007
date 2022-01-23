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
        //Робот ищет последовательность Х размером DOTS_TO_WIN-1 подряд, чтобы заблокировать ход с края

        //строки
        int count;
        for (int i = 0; i < map.length; i++) {
            count = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == DOT_X) {
                    count++;
                    if ((j + 1) < map[i].length && count == (DOTS_TO_WIN - 1)  && map[i][j + 1] == DOT_EMPTY) {
                        System.out.println("Робот делает ход в " + (j + 2) + " " + (i + 1));
                        map[i][j + 1] = DOT_0;
                        return;
                    } else if ((j - count) >= 0 && count == (DOTS_TO_WIN - 1) && map[i][j - count] == DOT_EMPTY) {
                        System.out.println("Робот делает ход в " + (j - count + 1) + " " + (i + 1));
                        map[i][j - count] = DOT_0;
                        return;
                    }
                } else {
                    count = 0;
                }
            }
        }



        //столбцы
        for (int j = 0; j < SIZE; j++) { //столбец
            count = 0;
            for (int i = 0; i < map.length; i++) {  // строка
                if (map[i][j] == DOT_X) {
                    count++;
                    if ((i + 1) < map.length && count == (DOTS_TO_WIN - 1)  && map[i + 1][j] == DOT_EMPTY) {
                        System.out.println("Робот делает ход в " + (j + 1) + " " + (i + 2));
                        map[i + 1][j] = DOT_0;
                        return;
                    } else if ((i - count) >= 0 && count == (DOTS_TO_WIN - 1) && map[i - count][j] == DOT_EMPTY) {
                        System.out.println("Робот делает ход в " + (j + 1) + " " + (i - count + 1));
                        map[i - count][j] = DOT_0;
                        return;
                    }
                } else {
                    count = 0;
                }
            }
        }


        //диагонали слева направо 1
        int diagonalCount = SIZE - DOTS_TO_WIN;
        for (int dc = -diagonalCount; dc <= diagonalCount; dc++) {
            count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if ((i - j + dc) == 0 && ((dc <= 0 && (i - j) >= 0) || ((dc > 0 && (j - i) > 0)))) {
                        if (map[i][j] == DOT_X) {
                            count++;
                            if ((i + 1) < map.length && (j + 1) < map[i].length && count == (DOTS_TO_WIN - 1)  && map[i + 1][j + 1] == DOT_EMPTY) {
                                System.out.println("Робот делает ход в " + (j + 2) + " " + (i + 2));
                                map[i + 1][j + 1] = DOT_0;
                                return;
                            } else if ((i - count) >= 0 && (j - count) >= 0 && count == (DOTS_TO_WIN - 1) && map[i - count][j - count] == DOT_EMPTY) {
                                System.out.println("Робот делает ход в " + (j - count + 1) + " " + (i - count + 1));
                                map[i - count][j - count] = DOT_0;
                                return;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
        }


        //диагонали справа налево 2
        for (int dc = -diagonalCount; dc <= diagonalCount; dc++) {
            count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if ((i + j) == (SIZE - 1 + dc)) {
                        if (map[i][j] == DOT_X) {
                            count++;
                            if ((i + 1) < map.length && (j - 1) >= 0 && count == (DOTS_TO_WIN - 1)  && map[i + 1][j - 1] == DOT_EMPTY) {
                                System.out.println("Робот делает ход в " + j + " " + (i + 2));
                                map[i + 1][j - 1] = DOT_0;
                                return;
                            } else if ((i - count) >= 0 && (j + count) < map[i].length && count == (DOTS_TO_WIN - 1) && map[i - count][j + count] == DOT_EMPTY) {
                                System.out.println("Робот делает ход в " + (j + count + 1) + " " + (i - count + 1));
                                map[i - count][j + count] = DOT_0;
                                return;
                            }
                        } else {
                            count = 0;
                        }
                    }
                }
            }
        }


        //Если робот не нашёл возможности заблокировать ход, ходит рандомно
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
        for (int j = 0; j < SIZE; j++) {
            count = 0;
            for (int i = 0; i < map.length; i++) {
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

        //диагонали слева направо
        int diagonalCount = SIZE - DOTS_TO_WIN;
        for (int dc = -diagonalCount; dc <= diagonalCount; dc++) {
            count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if ((i - j + dc) == 0 && ((dc <= 0 && (i - j) >= 0) || ((dc > 0 && (j - i) > 0)))) {
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
        }


        //диагонали справа налево
        for (int dc = -diagonalCount; dc <= diagonalCount; dc++) {
            count = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if ((i + j) == (SIZE - 1 + dc)) {
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
