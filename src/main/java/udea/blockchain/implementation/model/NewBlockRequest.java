package udea.blockchain.implementation.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewBlockRequest {
    private String transactionData;
    private int dificulty;
}
