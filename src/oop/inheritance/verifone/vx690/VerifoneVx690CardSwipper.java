package oop.inheritance.verifone.vx690;

import oop.inheritance.data.Card;
import oop.inheritance.data.EntryMode;
import oop.inheritance.data.ExpirationDate;

public class VerifoneVx690CardSwipper {
    private static VerifoneVx690CardSwipper instance;

    private VerifoneVx690CardSwipper(){}

    public static VerifoneVx690CardSwipper getInstance() {
        if (instance == null) {
            instance = new VerifoneVx690CardSwipper();
        }
        return instance;
    }

    public Card readCard(){
        return new Card("1246578514563698", new ExpirationDate(23,10), EntryMode.SWIPED);
    }
}
