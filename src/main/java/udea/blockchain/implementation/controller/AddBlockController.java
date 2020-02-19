package udea.blockchain.implementation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import udea.blockchain.implementation.model.NewBlockRequest;
import udea.blockchain.implementation.model.NewBlockResponse;

import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RequestMapping("/api")
public interface AddBlockController {

    @PostMapping(value = "/add-block", consumes = "application/json", produces = "application/json")
    ResponseEntity<NewBlockResponse> addBlock(@RequestBody NewBlockRequest request) throws NoSuchAlgorithmException;
}
