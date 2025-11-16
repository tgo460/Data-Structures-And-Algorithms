public class Interface {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();

        Bear b = new Bear();
        b.foodVeg();
        b.foodNonVeg();
    }
}


// Blue Print of a class


interface Herbivore {
    void foodVeg();
}

interface Carnivore {
    void foodNonVeg();
}

class Bear implements Herbivore, Carnivore {
    public void foodVeg() {
        System.out.println("Vegetables like Tomato, Potatos, Onion etc");
    }

    public void foodNonVeg() {
        System.out.println("Non-Veg Like Chicken, Meat, Fish etc");
    }
}

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("Left, Right, Top, Down, Diagonal (in all 4 dirns)");
    }
}
class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("Left, Right, Top, Down (Any Step)");
    }
}
class King implements ChessPlayer {
    public void moves() {
        System.out.println("Left, Right, Top, Down, Diagonal (only one step)");
    }
}

