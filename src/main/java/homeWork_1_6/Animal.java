package homeWork_1_6;

public class Animal {
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    public static int animalCount = 0;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;

        if(maxRunDistance>=0) {
            this.maxRunDistance = maxRunDistance;
        } else {
            System.out.println("Should be 0 or more meters for running");
        }

        if(maxSwimDistance>=0) {
            this.maxSwimDistance = maxSwimDistance;
        } else {
            System.out.println("Should be 0 or more meters for swimming");
        }

        animalCount++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        if(maxRunDistance>=0) {
            this.maxRunDistance = maxRunDistance;
        } else {
            System.out.println("Should be 0 or more meters for running");
        }
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public void setMaxSwimDistance(int maxSwimDistance) {
        if(maxSwimDistance>=0) {
            this.maxSwimDistance = maxSwimDistance;
        } else {
            System.out.println("Should be 0 or more meters for swimming");
        }
    }

    void run(int runDistance) {
        if (runDistance > 0 && runDistance <= maxRunDistance && maxRunDistance > 0) {
            System.out.println(name + " has run " + runDistance + " meters");
        } else if(maxRunDistance == 0) {
            System.out.println(name + " can't run at all");
        } else {
            System.out.println(name + " can't run " + runDistance +" meters");
        }
    }

    void swim(int swimDistance) {
        if (swimDistance > 0 && swimDistance <= maxSwimDistance && maxSwimDistance > 0) {
            System.out.println(name + " has swum " + swimDistance + " meters");
        } else if (maxSwimDistance == 0){
            System.out.println(name + " can't swim at all");
        } else {
            System.out.println(name + " can't swim " + swimDistance +" meters");

        }
    }


}
