package oop.inheritance.verifone.vx690;

import oop.inheritance.data.Factory.KeyboardFactory;

public class VerifoneVx690Keyboard implements KeyboardFactory{
    private static VerifoneVx690Keyboard instance;

    private VerifoneVx690Keyboard(){}

    public static VerifoneVx690Keyboard getInstance() {
        if (instance == null) {
            instance = new VerifoneVx690Keyboard();
        }
        return instance;
    }

    public String get(){
        return "Key pressed";
    }
}
