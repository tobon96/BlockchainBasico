package udea.blockchain.implementation.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewBlockRequest {
    private String transactionData;
    private int dificulty;
}
