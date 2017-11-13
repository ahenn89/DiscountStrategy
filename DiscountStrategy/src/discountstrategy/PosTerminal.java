package discountstrategy;

import edu.wctc.advjava.abh.datetime;

/**
 *
 * @author Ashlee
 */
public class PosTerminal {

    private Receipt receipt;
    private DateTime dateTime;
    //private int transactionId = 0;

    public PosTerminal(DateTime dateTime) {
        setDateTime(dateTime);
    }

    public final void startSale(String customerId, ReceiptDataAccessStrategy dataBase) throws IllegalArgumentException{
        if (customerId == null || customerId.isEmpty()) {
            customerId = "";
        } else if (dataBase == null) {
            throw new IllegalArgumentException("DataBase cannot be null when creating a new sale");
        }
        receipt = new Receipt(customerId, dataBase, dateTime);

    }

    public final void addItemToSale(String productId, double qty, ReceiptDataAccessStrategy dataBase) throws IllegalArgumentException{
        if (productId == null || productId.isEmpty()) {
            throw new IllegalArgumentException("ProductId cannot be null or empty");
        } else if (qty < 0 || qty > 1000) {
            throw new InvalidQuantityException();
        } else if (dataBase == null) {
            throw new IllegalArgumentException("DataBase cannot be null when creating a new sale");
        }
        receipt.createLineItem(productId, qty, dataBase);
    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        if (receipt == null) {
            throw new IllegalArgumentException("Receipt object is missing");
        }
        this.receipt = receipt;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setMyUtilities(DateTime dateTime) throws IllegalArgumentException {
        if (dateTime == null) {
            throw new IllegalArgumentException("dateUtilities cannot be null");
        }
        this.dateTime = dateTime;
    }

    public final void endSale(ReceiptOutputStrategy output, ReceiptOutputStrategy output2) throws IllegalArgumentException{
        if (output == null) {
            throw new IllegalArgumentException("OutputStrategy #1 is missing");
        } else if (output2 == null) {
            throw new IllegalArgumentException("OutputStrategy #2 is missing");
        }
        output.printReceipt(getReceipt());
        output2.printReceipt(getReceipt());
    }
}
