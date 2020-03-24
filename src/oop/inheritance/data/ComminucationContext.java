package oop.inheritance.data;

public class ComminucationContext {
    private CommunicationStrategy strategy;

    public ComminucationContext(CommunicationStrategy strategy){
        this.strategy = strategy;
    }

    public boolean open(){
        return strategy.open();
    }

    public boolean send(Transaction transaction){
        return strategy.send(transaction);
    }

    public TransactionResponse receive(){
        return strategy.receive();
    }

    public void close(){
        strategy.close();
    }
}
