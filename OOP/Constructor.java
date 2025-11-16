public class Constructor {
    public static void main(String[] args) {
        // Student s1 = new Student();
        // s1.name = "Ningappa";
        // s1.roll = 345;
        // s1.password = "abcd";
        // s1.marks[0] = 100;
        // s1.marks[1] = 90;
        // s1.marks[2] = 80;

        // Student s2 = new Student(s1);
        // s2.password = "xyz";

        // for (int i = 0; i < 3; i++) {
        //     System.out.println(s2.marks[i]);
        // }

        Fish shark = new Fish();

        shark.eat();

    }
}


// Inheritance concept
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

// Derived class
class Fish extends Animal {
    int fins;
    
    void swim() {
        System.out.println("Swims in water");
    }
}



// class Student {
//     String name;
//     int roll;
//     String password;
//     int marks[];

//     // Default Constructor - FIXED
//     Student() {
//         marks = new int[3];  // Initialize the array
//     }

//     // Parameterized Constructor
//     Student(String name) {
//         this.name = name;
//         marks = new int[3];  // Initialize the array
//     }

//     // Parameterized Constructor
//     Student(int roll) {
//         this.roll = roll;
//         marks = new int[3];  // Initialize the array
//     }

//     // Copy Constructor - FIXED (Deep Copy)
//     Student(Student s1) {
//         marks = new int[3];
//         this.name = s1.name;
//         this.roll = s1.roll;
//         this.password = s1.password;
        
//         // Deep copy of marks array
//         for (int i = 0; i < 3; i++) {
//             this.marks[i] = s1.marks[i];
//         }
//     }
// }