package lesson_1_7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    /**
     * Информация об оставшейся еде
     */
    public void info() {
        System.out.println("plate: " + food);
    }

    /**
     * Уменьшить еду на количество n
     * @param n
     */
    public void decreaseFood(int n) {
        if(n <= food){
            food -= n;
        } else {
            System.out.println("Столько еды нет");
        }
    }

    /**
     * Увеличить еду на количество n
     * @param n
     */
    public void increaseFood(int n) {
        food +=n;
    }
}
