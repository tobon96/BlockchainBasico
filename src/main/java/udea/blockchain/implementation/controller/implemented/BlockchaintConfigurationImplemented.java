package udea.blockchain.implementation.controller.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import udea.blockchain.implementation.controller.BlockchainConfigurationController;
import udea.blockchain.implementation.model.request.ConfigurationRequest;
import udea.blockchain.implementation.model.response.ConfigurationResponse;
import udea.blockchain.implementation.service.implemented.BlockchainConfigurationServiceImplemented;

@RestController
public class BlockchaintConfigurationImplemented implements BlockchainConfigurationController {

    @Autowired
    private BlockchainConfigurationServiceImplemented configurationService;

    @Override
    public ResponseEntity<String> changeDifficulty(int difficulty) {
        return ResponseEntity.ok().body(configurationService.changeDifficulty(difficulty));
    }

    @Override
    public ResponseEntity<ConfigurationResponse> blockchainInitialConfig(ConfigurationRequest request) {
        return ResponseEntity.accepted().body(configurationService.setConfig(request));
    }
}
