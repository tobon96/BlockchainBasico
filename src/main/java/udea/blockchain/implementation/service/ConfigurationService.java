package udea.blockchain.implementation.service;

import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.request.ConfigurationRequest;
import udea.blockchain.implementation.model.response.ConfigurationResponse;

import java.security.NoSuchAlgorithmException;

public interface ConfigurationService {
    ConfigurationResponse setConfig(ConfigurationRequest request) throws NoSuchAlgorithmException;
}
