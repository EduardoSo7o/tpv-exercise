package oop.inheritance.verifone.vx520;

import oop.inheritance.data.Factory.DisplayFactory;

public class VerifoneVx520Display implements  DisplayFactory{
    private static VerifoneVx520Display instance;

    private VerifoneVx520Display() {
    }

    public static VerifoneVx520Display getInstance() {
        if (instance == null) {
            instance = new VerifoneVx520Display();
        }

        return instance;
    }

    /**
     * Prints a message to specied position
     *
     * @param x       horizontal position
     * @param y       vertical position
     * @param message message to be printed
     */
    public void showMessage(int x, int y, String message) {
    }

    /**
     * Clears the screen
     */
    public void clear() {

    }
}
