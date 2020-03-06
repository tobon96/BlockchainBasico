package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Transaction {
    private String from;
    private double quantity;
    private String to;
    private Optional<String> password;

    public Transaction(String from, int quantity, String to, Optional<String> password) {
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
        this.from = "Mine address";
        this.quantity = 20;
        this.to = "First miner";
    }
}
