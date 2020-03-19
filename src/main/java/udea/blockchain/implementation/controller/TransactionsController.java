package udea.blockchain.implementation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import udea.blockchain.implementation.model.model.Transaction;
import udea.blockchain.implementation.model.response.ConfigurationResponse;

import java.util.Optional;

@CrossOrigin
@RequestMapping("/api")
public interface TransactionsController {

    @PostMapping(value = "/add-transaction", consumes = "application/json", produces = "application/json")
    ResponseEntity addTransaction(@RequestBody Transaction request) throws Exception;
}
