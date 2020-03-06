package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BlockBody {
    private ArrayList<Transaction> transactions;

    public BlockBody() {
        Transaction primitiveTransaction = new Transaction();
        transactions = new ArrayList<Transaction>();
        transactions.add(primitiveTransaction);
    }

    public BlockBody(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

}
