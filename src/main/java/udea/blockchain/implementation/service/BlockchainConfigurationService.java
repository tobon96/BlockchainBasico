package udea.blockchain.implementation.service;

import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.request.ConfigurationRequest;
import udea.blockchain.implementation.model.response.ConfigurationResponse;

public interface BlockchainConfigurationService {
    String changeDifficulty(int difficulty);
    ConfigurationResponse setConfig(ConfigurationRequest request);
}
