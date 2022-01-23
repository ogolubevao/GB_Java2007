package homeWork_1_6;

public class Cat extends  Animal{

    public static int catCount = 0;

    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    @Override
    public void setMaxRunDistance(int maxRunDistance) {
        if(maxRunDistance>=0 && maxRunDistance <= 200) {
            this.maxRunDistance = maxRunDistance;
        } else {
            System.out.println("Should be 0-200 meters for cat's running");
        }
    }

    @Override
    public void setMaxSwimDistance(int maxSwimDistance) {
        if(maxSwimDistance==0) {
            this.maxSwimDistance = maxSwimDistance;
        } else {
            System.out.println("Cats can't swim");
        }
    }
}
