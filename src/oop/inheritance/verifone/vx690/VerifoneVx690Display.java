package oop.inheritance.verifone.vx690;

import oop.inheritance.data.Factory.DisplayFactory;

public class VerifoneVx690Display implements DisplayFactory{
    private static VerifoneVx690Display instance;

    private VerifoneVx690Display() {
    }

    public static VerifoneVx690Display getInstance() {
        if (instance == null) {
            instance = new VerifoneVx690Display();
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
