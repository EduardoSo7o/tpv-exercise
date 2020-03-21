package oop.inheritance.ingenico;

import oop.inheritance.data.Card;
import oop.inheritance.data.EntryMode;
import oop.inheritance.data.ExpirationDate;

public class IngenicoChipReader {
    private static IngenicoChipReader instance;

    private IngenicoChipReader(){}

    public static IngenicoChipReader getInstance() {
        if (instance == null) {
            instance = new IngenicoChipReader();
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
