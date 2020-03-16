package udea.blockchain.implementation.controller.implemented;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import udea.blockchain.implementation.controller.TransactionsController;
import udea.blockchain.implementation.model.model.Transaction;
import udea.blockchain.implementation.model.response.ConfigurationResponse;

import java.util.Optional;

@RestController
public class TransactionsControllerImplemented implements TransactionsController {

    @Override
    public ResponseEntity<Optional<ConfigurationResponse>> blockchainInitialConfig(Transaction request) {
        return null;
    }
}
