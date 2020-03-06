package udea.blockchain.implementation.service.implemented;

import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.model.Blockchain;
import udea.blockchain.implementation.model.request.ConfigurationRequest;
import udea.blockchain.implementation.model.response.ConfigurationResponse;
import udea.blockchain.implementation.service.ConfigurationService;

@Service
public class ConfigurationServiceImplemented implements ConfigurationService {
    @Override
    public ConfigurationResponse setConfig(ConfigurationRequest request) {
        Blockchain.setDifficulty(request.getDifficulty().orElse(3));
        Blockchain.getInstance().setTransactionLimit(request.getTransactionLimit().orElse(3));
        if(request.getMaximumTokens().isPresent()) {
            Blockchain.getInstance().setMine(request.getMaximumTokens().getAsDouble());
        }

        return new ConfigurationResponse(Blockchain.getDifficulty() ,Blockchain.getInstance().getTransactionLimit(), Blockchain.getInstance().getMine(), "Configuration updated successfully");
    }
}
