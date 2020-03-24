package oop.inheritance.verifone.v240m;

import oop.inheritance.data.Card;
import oop.inheritance.data.EntryMode;
import oop.inheritance.data.ExpirationDate;

public class VerifoneV240mChipReader {
    private static VerifoneV240mChipReader instance;

    private VerifoneV240mChipReader(){}

    public static VerifoneV240mChipReader getInstance() {
        if (instance == null) {
            instance = new VerifoneV240mChipReader();
        }
        return instance;
    }

    public Card readCard() {
        return Card.builder()
                .account("4558211532252558")
                .entryMode(EntryMode.INSERTED)
                .expirationDate(ExpirationDate.builder()
                        .year(20)
                        .month(8)
                        .build())
                .build();
    }

}
