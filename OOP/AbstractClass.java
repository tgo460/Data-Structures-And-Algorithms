public class AbstractClass {
    public static void main (String[] args) {
        Horse h = new Horse();
        h.eat();
        h.walk();

        System.out.println(h.color);

        Chicken c = new Chicken();
        System.out.println(h.color);
        c.eat();
        c.walk();


    }
}

abstract class Animal {
    String color;

    Animal() {
        System.out.print("Animal constructor is called");
    }

    // Animal() {
    //     color = "Brown";
    // }

    void eat() {
        System.out.println("Animal Eats");
    }

    abstract void walk();
}

class Horse extends Animal {

    Horse() {
        System.out.println("Horse Constructor is called");
    }

    void changeColor() {
        color = "Dark Brown";
    }


    void walk() {
        String name = "Brat";
        System.out.println(name + " is a Horse it Walks on 4 legs");
    }
}

class Chicken extends Animal {

    Chicken() {
        System.out.println("Chicken Constructor is called");
    }
    void changeColor() {
        color = "Yellow";
    }

    void walk() {
        System.out.println("Walks on 2 legs");
    }
}