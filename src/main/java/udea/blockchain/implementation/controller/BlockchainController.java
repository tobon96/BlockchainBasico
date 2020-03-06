package udea.blockchain.implementation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.blockchain.implementation.model.model.Block;
import udea.blockchain.implementation.model.request.NewBlockRequest;
import udea.blockchain.implementation.model.response.GetBlockchainResponse;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@CrossOrigin
@RequestMapping("/api")
public interface BlockchainController {

    @PostMapping(value = "/add-block", consumes = "application/json", produces = "application/json")
    ResponseEntity<String> addBlock(@RequestBody NewBlockRequest request) throws NoSuchAlgorithmException;

    @GetMapping(value = "/get-blockchain", produces = "application/json")
    ResponseEntity<GetBlockchainResponse> getBlockchain();
}
