package oop.inheritance.verifone.v240m;

import oop.inheritance.data.Factory.KeyboardFactory;

public class VerifoneV240mKeyboard implements KeyboardFactory{
    private static VerifoneV240mKeyboard instance;

    private VerifoneV240mKeyboard(){}

    public static VerifoneV240mKeyboard getInstance() {
        if (instance == null) {
            instance = new VerifoneV240mKeyboard();
        }
        return instance;
    }

    public String get(){
        return "Key pressed";
    }
}
