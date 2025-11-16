public class ClassesAndObj {
    public static void main(String[] args) {
        // Creating Objects (instances)
        Person person1 = new Person("Alice", 25, "alice@email.com");
        Person person2 = new Person("Bob", 30, "bob@email.com");

        person1.introduce();
    }
}

class Person {
    // Fields(instance variables)
    String name;
    int age;
    String email;

    // constructor
    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    // Methods
    public void introduce() {
        System.out.println("Hi, I'm " + name + " and I'm " + age + " years old.");
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }


    // Using Object Methods
    person1.introduce();
    
}
