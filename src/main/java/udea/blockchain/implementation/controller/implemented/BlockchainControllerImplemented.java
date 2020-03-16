package udea.blockchain.implementation.controller.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udea.blockchain.implementation.controller.BlockchainController;
import udea.blockchain.implementation.model.model.Block;
import udea.blockchain.implementation.model.model.Blockchain;
import udea.blockchain.implementation.model.request.NewBlockRequest;
import udea.blockchain.implementation.model.response.GetBlockchainResponse;
import udea.blockchain.implementation.service.implemented.BlockchainServiceImplemented;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@CrossOrigin
@RequestMapping("/api")
public class BlockchainControllerImplemented implements BlockchainController {

    @Autowired
    private BlockchainServiceImplemented blockchainService;

    @Override
    public ResponseEntity<String> addBlock(NewBlockRequest request) throws NoSuchAlgorithmException {
        return ResponseEntity.ok().body("Todo vientos");
    }

    @Override
    public ResponseEntity<GetBlockchainResponse> getBlockchain() {
        return ResponseEntity.ok().body(blockchainService.getBlockchain());
    }
}
