package oop.inheritance.verifone.v240m;

import oop.inheritance.data.DisplayFactory;

public class VerifoneV240mDisplay implements DisplayFactory{

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
