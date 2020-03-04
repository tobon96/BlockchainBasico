package udea.blockchain.implementation.service.implemented;

import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.model.Blockchain;
import udea.blockchain.implementation.model.request.ConfigurationRequest;
import udea.blockchain.implementation.model.response.ConfigurationResponse;
import udea.blockchain.implementation.service.BlockchainConfigurationService;

@Service
public class BlockchainConfigurationServiceImplemented implements BlockchainConfigurationService {

    @Override
    public String changeDifficulty(int difficulty) {
        Blockchain.getInstance().setDifficulty(difficulty);
        return "New Blockchain difficulty: " + Blockchain.getInstance().getDifficulty();
    }

    @Override
    public ConfigurationResponse setConfig(ConfigurationRequest request) {
        Blockchain.getInstance().setDifficulty(request.getDifficulty().orElse(3));
        Blockchain.getInstance().setTransactionLimit(request.getTransactionLimit().orElse(3));
        if(request.getMaximumTokens().isPresent()){
            Blockchain.getInstance().setMine(request.getMaximumTokens().getAsDouble());
        }
        return null;
    }
}
