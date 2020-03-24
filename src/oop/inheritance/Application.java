package oop.inheritance;

import java.time.LocalDateTime;

import oop.inheritance.data.*;
import oop.inheritance.data.Factory.*;
import oop.inheritance.ingenico.*;
import oop.inheritance.verifone.v240m.*;
import oop.inheritance.verifone.vx520.*;
import oop.inheritance.verifone.vx690.*;

import static oop.inheritance.data.SupportedTerminal.*;

public class Application {

    private CommunicationType communicationType = CommunicationType.ETHERNET;
    private SupportedTerminal supportedTerminal;
    private CardSwipperFactory cardSwipper;
    private ChipReaderFactory chipReader;
    private DisplayFactory display;
    private KeyboardFactory keyboard;
    private EthernetFactory ethernet;
    private GPSFactory gps;
    private ModemFactory modem;
    private PrinterFactory printer;

    public Application(SupportedTerminal supportedTerminal) {
        this.supportedTerminal = supportedTerminal;

        switch (supportedTerminal){
            case INGENICO:
                cardSwipper = IngenicoCardSwipper.getInstance();
                chipReader = IngenicoChipReader.getInstance();
                display = IngenicoDisplay.getInstance();
                keyboard = IngenicoKeyboard.getInstance();
                ethernet = IngenicoEthernet.getInstance();
                gps = IngenicoGPS.getInstance();
                modem = IngenicoModem.getInstance();
                printer = IngenicoPrinter.getInstance();
                break;

            case VERIFONEv240m:
                cardSwipper = VerifoneV240mCardSwipper.getInstance();
                chipReader = VerifoneV240mChipReader.getInstance();
                display = VerifoneV240mDisplay.getInstance();
                keyboard = VerifoneV240mKeyboard.getInstance();
                ethernet = VerifoneV240mEthernet.getInstance();
                gps = VerifoneV240mGPS.getInstance();
                modem = VerifoneV240mModem.getInstance();
                printer = VerifoneV240mPrinter.getInstance();
                break;

            case VERIFONEvx520:
                cardSwipper = VerifoneVx520CardSwipper.getInstance();
                chipReader = VerifoneVx520ChipReader.getInstance();
                display = VerifoneVx520Display.getInstance();
                keyboard = VerifoneVx520Keyboard.getInstance();
                ethernet = VerifoneVx520Ethernet.getInstance();
                gps = VerifoneVx520GPS.getInstance();
                modem = VerifoneVx520Modem.getInstance();
                printer = VerifoneVx520Printer.getInstance();
                break;

            case VERIFONEvx690:
                cardSwipper = VerifoneVx690CardSwipper.getInstance();
                chipReader = VerifoneVx690ChipReader.getInstance();
                display = VerifoneVx690Display.getInstance();
                keyboard = VerifoneVx690Keyboard.getInstance();
                ethernet = VerifoneVx690Ethernet.getInstance();
                gps = VerifoneVx690GPS.getInstance();
                modem = VerifoneVx690Modem.getInstance();
                printer = VerifoneVx690Printer.getInstance();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + supportedTerminal);
        }
    }

    public void showMenu() {
        display.showMessage(5, 5, "MENU");
        display.showMessage(5, 10, "1. VENTA");
        display.showMessage(5, 13, "2. DEVOLUCION");
        display.showMessage(5, 16, "3. REPORTE");
        display.showMessage(5, 23, "4. CONFIGURACION");

    }

    public String readKey() {
        return keyboard.get();
    }

    public void doSale() {
        Card card;

        do {
            card = cardSwipper.readCard();
            if (card == null) {
                card = chipReader.readCard();
            }
        } while (card == null);

        display.clear();
        display.showMessage(5, 20, "Capture monto:");

        String amount = keyboard.get(); //Amount with decimal point as string

        Transaction transaction = new Transaction();

        transaction.setLocalDateTime(LocalDateTime.now());
        transaction.setCard(card);
        transaction.setAmountInCents(Integer.parseInt(amount.replace(".", "")));

        TransactionResponse response = sendSale(transaction);

        if (response.isApproved()) {
            display.showMessage(5, 25, "APROBADA");
            printReceipt(transaction, response.getHostReference());
        } else {
            display.showMessage(5, 25, "DENEGADA");
        }
    }

    private void printReceipt(Transaction transaction, String hostReference) {
        Card card = transaction.getCard();

        printer.print(5, "APROBADA");
        printer.lineFeed();
        printer.print(5, card.getAccount());
        printer.lineFeed();
        printer.print(5, "" + transaction.getAmountInCents());
        printer.lineFeed();
        printer.print(5, "________________");

    }

    private TransactionResponse sendSale(Transaction transaction) {
        TransactionResponse transactionResponse = null;

        switch (communicationType) {
            case ETHERNET:
                ethernet.open();
                ethernet.send(transaction);
                transactionResponse = ethernet.receive();
                ethernet.close();
                break;
            case GPS:
                gps.open();
                gps.send(transaction);
                transactionResponse = gps.receive();
                gps.close();
                break;
            case MODEM:
                modem.open();
                modem.send(transaction);
                transactionResponse = modem.receive();
                modem.close();
                break;
        }

        return transactionResponse;
    }

    public void doRefund() {
    }

    public void printReport() {
    }

    public void showConfiguration() {
    }

    public void clearScreen() {
        display.clear();
    }
}
