package oop.inheritance.verifone.vx520;

import oop.inheritance.data.Card;
import oop.inheritance.data.EntryMode;
import oop.inheritance.data.ExpirationDate;

public class VerifoneVx520CardSwipper {

    private static VerifoneVx520CardSwipper instance;

    private VerifoneVx520CardSwipper(){}

    public static VerifoneVx520CardSwipper getInstance() {
        if (instance == null) {
            instance = new VerifoneVx520CardSwipper();
        }
        return instance;
    }

    public Card readCard(){
        return new Card("1246578514563698", new ExpirationDate(23,10), EntryMode.SWIPED);
    }
}
