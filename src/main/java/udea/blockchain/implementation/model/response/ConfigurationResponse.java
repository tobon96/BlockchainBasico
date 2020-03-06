package udea.blockchain.implementation.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConfigurationResponse {

    private int difficulty;
    private int transactionLimit;
    private double mine;
    private String message;

    public ConfigurationResponse(int difficulty, int transactionLimit, double mine, String message) {
        this.difficulty = difficulty;
        this.transactionLimit = transactionLimit;
        this.mine = mine;
        this.message = message;
    }
}
