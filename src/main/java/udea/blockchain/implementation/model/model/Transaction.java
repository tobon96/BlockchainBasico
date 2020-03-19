package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private byte[] from;
    private double quantity;
    private byte[] to;

    public Transaction(byte[] from, int quantity, byte[] to) {
        this.from = from;
        this.quantity = quantity;
        this.to = to;
    }

    public Transaction() {

    }
}
