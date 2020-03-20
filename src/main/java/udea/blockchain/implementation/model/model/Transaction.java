package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;
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
