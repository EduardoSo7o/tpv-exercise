package oop.inheritance.verifone.v240m;

import oop.inheritance.data.Factory.DisplayFactory;

public class VerifoneV240mDisplay implements DisplayFactory{
    private static VerifoneV240mDisplay instance;

    private VerifoneV240mDisplay() {
    }

    public static VerifoneV240mDisplay getInstance() {
        if (instance == null) {
            instance = new VerifoneV240mDisplay();
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

    @Override
    public void showMessage(int x, int y, String message) {
    }

    /**
     * Clears the screen
     */

    @Override
    public void clear() {

    }
}
