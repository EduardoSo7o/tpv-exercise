package oop.inheritance.verifone.vx520;

import oop.inheritance.data.Factory.KeyboardFactory;

public class VerifoneVx520Keyboard implements KeyboardFactory{
    private static VerifoneVx520Keyboard instance;

    private VerifoneVx520Keyboard(){}

    public static VerifoneVx520Keyboard getInstance() {
        if (instance == null) {
            instance = new VerifoneVx520Keyboard();
        }
        return instance;
    }

    public String get(){
        return "Key pressed";
    }
}
