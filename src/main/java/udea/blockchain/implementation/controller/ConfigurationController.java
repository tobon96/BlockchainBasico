package udea.blockchain.implementation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.blockchain.implementation.model.request.ConfigurationRequest;
import udea.blockchain.implementation.model.response.ConfigurationResponse;

import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RequestMapping("/api")
public interface ConfigurationController {

    @PutMapping(value = "/config", consumes = "application/json", produces = "application/json")
    ResponseEntity<ConfigurationResponse> blockchainInitialConfig(@RequestBody ConfigurationRequest request) throws NoSuchAlgorithmException;
}
