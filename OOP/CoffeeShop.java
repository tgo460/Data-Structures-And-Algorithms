// Remove this line: package OOP;

// 1. The Blueprint (class)
class SingingMug {
    // state (fields)
    private String ownerName;
    private int volumeML;

    // Constructor - the factory line
    public SingingMug(String ownerName, int volumeML) {
        this.ownerName = ownerName;
        this.volumeML = volumeML;
    }

    // behavior (method)
    public void sip() {
        System.out.println("♪ Sip-sip, cheers " + ownerName + "! ♪");
    }

    public int remaining() {
        return volumeML;
    }
}

// 2. The Actual Mug (Object)
public class CoffeeShop {
    public static void main(String[] args) {
        SingingMug myMug = new SingingMug("Ninga", 350);
        // Object born
        myMug.sip(); // prints : ♪ Sip-sip, cheers Ninga! ♪
    }
}