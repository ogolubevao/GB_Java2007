package lesson_1_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFull() {
        return isFull;
    }

    /**
     * Кормление кота с тарелки
     * @param plate объект Plate
     */
    public void eat(Plate plate) {
        if(appetite <= plate.getFood()) {
            plate.decreaseFood(appetite);
            isFull = true;
        } else {
            System.out.println("Недостаточно еды для кормёжки");
            isFull = false;
        }
    }

    @Override
    public String toString() {
        return name + " " + appetite + " " + isFull;
    }
}
