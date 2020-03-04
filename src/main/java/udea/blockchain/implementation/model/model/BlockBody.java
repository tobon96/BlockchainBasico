package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class BlockBody {
    private ArrayList<Transaction> transactions;
    private final int transactionLimit = 5;
}
