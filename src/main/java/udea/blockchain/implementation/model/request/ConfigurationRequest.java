package udea.blockchain.implementation.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;

@Getter
@Setter
public class ConfigurationRequest {

    private OptionalInt difficulty;
    private OptionalInt transactionLimit;
    private OptionalDouble maximumTokens;

}
