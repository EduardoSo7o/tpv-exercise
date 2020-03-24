package oop.inheritance.data.Factory;

import oop.inheritance.data.Transaction;
import oop.inheritance.data.TransactionResponse;

public interface EthernetFactory {
    boolean open();
    boolean send(Transaction transaction);
    TransactionResponse receive();
    void close();
}
