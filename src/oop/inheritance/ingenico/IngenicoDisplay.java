package oop.inheritance.ingenico;

import oop.inheritance.data.Factory.DisplayFactory;

public class IngenicoDisplay implements DisplayFactory {
    private static IngenicoDisplay instance;

    private IngenicoDisplay() {
    }

    public static IngenicoDisplay getInstance() {
        if (instance == null) {
            instance = new IngenicoDisplay();
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
