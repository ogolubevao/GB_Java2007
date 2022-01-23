package lesson_1_7;

import java.util.Arrays;

public class CatApp {
    public static void main(String[] args) {
        Cat cat = new Cat("Frodo", 45);
        Plate plate = new Plate(115);
        plate.info();

        cat.eat(plate);
        cat.eat(plate);
        plate.info();

        Cat[] cats = new Cat[4];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("cat" + i, 5 + i * 5);
        }

        System.out.println(Arrays.toString(cats));

        System.out.println();
        System.out.println();
        for (Cat c: cats) {
            c.eat(plate);
            StringBuffer str = new StringBuffer();
            System.out.println(str.append(c.getName()).append(" ").append(c.isFull()));
        }

        plate.increaseFood(200);
        System.out.println();
        System.out.println();
        for (Cat c: cats) {
            c.eat(plate);
            StringBuffer str = new StringBuffer();
            System.out.println(str.append(c.getName()).append(" ").append(c.isFull()));
        }
    }
}
