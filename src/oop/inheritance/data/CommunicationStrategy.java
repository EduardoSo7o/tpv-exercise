package oop.inheritance.data;

public interface CommunicationStrategy {
    boolean open();
    boolean send(Transaction transaction);
    TransactionResponse receive();
    void close();
}
