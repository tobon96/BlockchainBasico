package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private String from;
    private double quantity;
    private String to;
    private String password;

    public Transaction(String from, int quantity, String to, String  password) {
        this.from = from;
        this.quantity = quantity;
        this.to = to;
        this.password = password;
    }

    public Transaction(String from, int quantity, String to) {
        this.from = from;
        this.quantity = quantity;
        this.to = to;
    }

    public Transaction() {

    }
}
