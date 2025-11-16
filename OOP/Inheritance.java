public class Inheritance {
    public static void main(String[] args) {
        Bird peigen = new Bird();

        peigen.fly();
    }
}



// Base Class
class Animal {
    String color;

    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breathes");
    }
}

class Fish extends Animal {
    void swim() {
        System.out.println("swim");
    }
}


class Mammal extends Animal {
    void walk() {
        System.out.println("walks");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("fly");
    }
}



// class Mammal extends Animal {
//     int legs;

// }

// class Dog extends Mammal {
//     String breed;
// }


// // Derived Class

// class Fish extends Animal {
//     int fins;

//     void swim() {
//         System.out.println("Swims in Water");
//     }
// }