package udea.blockchain.implementation.controller.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import udea.blockchain.implementation.controller.ConfigurationController;
import udea.blockchain.implementation.model.request.ConfigurationRequest;
import udea.blockchain.implementation.model.response.ConfigurationResponse;
import udea.blockchain.implementation.service.implemented.ConfigurationServiceImplemented;

import java.security.NoSuchAlgorithmException;

@RestController
public class ConfigurationControllerImplemented implements ConfigurationController {

    @Autowired
    private ConfigurationServiceImplemented configurationService;

    @Override
    public ResponseEntity<ConfigurationResponse> blockchainInitialConfig(ConfigurationRequest request) throws NoSuchAlgorithmException {
        return ResponseEntity.accepted().body(configurationService.setConfig(request));
    }
}
