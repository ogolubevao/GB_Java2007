package homeWork_1_6;

public class Dog extends Animal {
    public static int dogCount = 0;

    public Dog(String name) {
        super(name, 500, 10);
        dogCount++;
    }

    @Override
    public void setMaxRunDistance(int maxRunDistance) {
        if(maxRunDistance>=0 && maxRunDistance <= 500) {
            this.maxRunDistance = maxRunDistance;
        } else {
            System.out.println("Should be 0-500 meters for dog's running");
        }
    }

    @Override
    public void setMaxSwimDistance(int maxSwimDistance) {
        if(maxSwimDistance>=0 && maxSwimDistance <= 10) {
            this.maxSwimDistance = maxSwimDistance;
        } else {
            System.out.println("Should be 0-10 meters for dog's swimming");
        }
    }
}
