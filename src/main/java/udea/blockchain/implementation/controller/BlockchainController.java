package udea.blockchain.implementation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.blockchain.implementation.model.model.Block;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@CrossOrigin
@RequestMapping("/api")
public interface BlockchainController {

    @GetMapping(value = "/get-blockchain", produces = "application/json")
    ResponseEntity<ArrayList<Block>> getBlockchain();

    @GetMapping(value = "mine-block", produces = "application/json")
    ResponseEntity mineBlock() throws NoSuchAlgorithmException;
}
