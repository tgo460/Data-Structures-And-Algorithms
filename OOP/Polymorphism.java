public class Polymorphism {
    public static void main(String[] args) {
        Deer deer = new Deer();

        deer.eat();

    }
}

class Animal {
    void eat() {
        System.out.println("Eats Anything");
    }
}

class Deer extends Animal {
    void eat() {
        System.out.println("Eats Grass");
    }
}






// class Calculator {
//     int sum(int a, int b) {
//         return a + b;
//     }

//     float sum(float a, float b) {
//         return a + b;
//     }

//     int sum(int a, int b, int c) {
//         return a + b + c;
//     }
// }
