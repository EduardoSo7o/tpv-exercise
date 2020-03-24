package oop.inheritance.verifone.vx520;

public class VerifoneVx520Printer {
    private static VerifoneVx520Printer instance;

    private VerifoneVx520Printer(){}

    public static VerifoneVx520Printer getInstance(){
        if(instance == null){
            instance = new VerifoneVx520Printer();
        }
        return instance;
    }

    /**
     * Prints a message on the current line at the specified horizontal position
     *
     * @param x       horizontal offset
     * @param message Message to be printed
     */
    public void print(int x, String message) {

    }

    /**
     * Add a line break to the paper
     */
    public void lineFeed() {
    }

}
