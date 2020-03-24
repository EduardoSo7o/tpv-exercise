package oop.inheritance.ingenico;

import oop.inheritance.data.Factory.KeyboardFactory;

public class IngenicoKeyboard implements KeyboardFactory{
    private static IngenicoKeyboard instance;

    private IngenicoKeyboard(){}

    public static IngenicoKeyboard getInstance() {
        if (instance == null) {
            instance = new IngenicoKeyboard();
        }
        return instance;
    }

    /**
     * @return key pressed
     */
    public String get() {
        return "Key pressed";
    }
}
