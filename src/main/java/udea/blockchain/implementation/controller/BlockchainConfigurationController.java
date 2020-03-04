package udea.blockchain.implementation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.blockchain.implementation.model.request.ConfigurationRequest;
import udea.blockchain.implementation.model.response.ConfigurationResponse;

@CrossOrigin
@RequestMapping("/api")
public interface BlockchainConfigurationController {

    @PutMapping(value = "/change-difficulty", produces = "application/json")
    ResponseEntity<String> changeDifficulty(@RequestParam int difficulty );

    @PostMapping(value = "/start-config", consumes = "application/json", produces = "application/json")
    ResponseEntity<ConfigurationResponse> blockchainInitialConfig(@RequestBody ConfigurationRequest request);
}
