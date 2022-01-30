package homeWork_1_6;

public class AnimalApp {
    public static void main(String[] args) {
        Cat cat = new Cat("Oleg");
        Dog dog = new Dog("Kuzya");
        Animal animal = new Animal("Wow", 105, 25);

        cat.run(50);
        cat.swim(50);
        dog.run(100);
        dog.swim(100);

        cat.setMaxSwimDistance(10);

        System.out.println("Total animals = " + Animal.animalCount);
        System.out.println("Total cats = " + Cat.catCount);
        System.out.println("Total dogs = " + Dog.dogCount);
    }
}
