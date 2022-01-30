
package lesson_1_8;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Arrays;
        import java.util.Random;

public class XOApp_v2_0 extends JFrame {

    //Игровое поле
    public static char[][] map;

    //Размер поля
    public static final int SIZE = 8;

    //Точек для победы
    public static final int DOTS_TO_WIN = 3;

    //Описание точек
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_0 = '0';

    //Рандом
    public static final Random RANDOM = new Random();

    //Уведомление об окончании игры
    public static JLabel finalLabel = new JLabel();

    //Кнопка повтора игры
    public static JButton playAgain =new JButton();



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
        new XOApp_v2_0();
    }

    public XOApp_v2_0() {
        //Font
        Font font = new Font("Arial", Font.BOLD, 38);
        Font font1 = new Font("Arial", Font.BOLD, 20);

        //Buttons
        JButton[][] buttons = new JButton[SIZE][SIZE];
        JButton submit = new JButton();
        submit.setText("OK");


        //TextFields
        JTextField sizeArea = new JTextField(0);
        JTextField dotsArea = new JTextField(0);
        sizeArea.setFont(font);
        dotsArea.setFont(font);

        //Panels
        JPanel grid = new JPanel();
        grid.setLayout(new GridLayout(SIZE,SIZE));
        add(grid, BorderLayout.CENTER);


        //
        finalLabel.setFont(font1);
        finalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(finalLabel, BorderLayout.NORTH);

        playAgain.setFont(font);
        playAgain.setHorizontalAlignment(SwingConstants.CENTER);
        playAgain.setText("Играть ещё");
        playAgain.setVisible(false);
        add(playAgain, BorderLayout.SOUTH);
        playAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalLabel.setText("");
                initMap();
                for (int i = 0; i < buttons.length; i++) {
                    for (int j = 0; j < buttons[i].length; j++) {
                        buttons[i][j].setText(String.valueOf(map[i][j]));
                        buttons[i][j].setEnabled(true);
                    }

                }
                playAgain.setVisible(false);
            }
        });






        //Window
        setBounds(500, 200, 500, 500);
        setTitle("Counter App");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        initMap();
        ActionListener[][] listeners = new ActionListener[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                buttons[i][j] = new JButton(String.valueOf(map[i][j]));
                //button.set
                buttons[i][j].setFont(font);
                grid.add(buttons[i][j]);
                listeners[i][j] = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource() instanceof JButton) {
                            ((JButton)e.getSource()).setText(String.valueOf(DOT_X));
                            ((JButton)e.getSource()).setEnabled(false);

                            for (int i = 0; i < map.length; i++) {
                                for (int j = 0; j < map[i].length; j++) {
                                    map[i][j] = (buttons[i][j].getText()).charAt(0);
                                }
                            }
                            if (checkWin(DOT_X)) {
                                finalLabel.setText("Побеждает человек");
                                //endGame("Побеждает человек");
                                System.out.println("Побеждает человек");
                                playAgain.setVisible(true);
                                enableGrid(buttons, false);
                                return;
                                //break;
                            }
                            if (isMapFull()) {
                                finalLabel.setText("Ничья!");
                                System.out.println("Ничья!");
                                enableGrid(buttons, false);
                                playAgain.setVisible(true);
                                return;
                                //break;
                            }
                            aiTurn();
                            for (int i = 0; i < map.length; i++) {
                                for (int j = 0; j < map[i].length; j++) {
                                    buttons[i][j].setText(String.valueOf(map[i][j]));
                                    if((buttons[i][j].getText()).charAt(0) == DOT_0) {
                                        buttons[i][j].setEnabled(false);
                                    }
                                }
                            }
                            if (checkWin(DOT_0)) {
                                finalLabel.setText("Побеждает компьютер");
                                System.out.println("Побеждает компьютер");
                                enableGrid(buttons, false);
                                playAgain.setVisible(true);
                                return;
                            }
                            if (isMapFull()) {
                                finalLabel.setText("Ничья!");
                                System.out.println("Ничья!");
                                playAgain.setVisible(true);
                                enableGrid(buttons, false);
                                //return;
                            }
                        }
                    }
                };
                buttons[i][j].addActionListener(listeners[i][j]);
            }
        }

        setVisible(true);
    }

    /**
     * Делает матрицу некликабельной
     * @param bye массив кнопок JButton
     */
    public void enableGrid (JButton[][] bye, boolean boo) {
        for (int i = 0; i < bye.length; i++) {
            for (int j = 0; j < bye[i].length; j++) {
                bye[i][j].setEnabled(boo);
            }

        }
    }
}

