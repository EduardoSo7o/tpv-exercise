package oop.inheritance.data.Factory;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;

public interface GPSFactory {
    boolean open();
    boolean send(Transaction message);
    TransactionResponse receive();
    void close();
}
