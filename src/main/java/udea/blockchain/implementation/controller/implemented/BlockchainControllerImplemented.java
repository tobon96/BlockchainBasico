package udea.blockchain.implementation.controller.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import udea.blockchain.implementation.controller.BlockchainController;
import udea.blockchain.implementation.model.model.Block;
import udea.blockchain.implementation.service.implemented.BlockchainServiceImplemented;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@RestController
public class BlockchainControllerImplemented implements BlockchainController {

    @Autowired
    private BlockchainServiceImplemented blockchainService;

    @Override
    public ResponseEntity<ArrayList<Block>> getBlockchain() {
        return ResponseEntity.ok().body(blockchainService.getBlockchain());
    }

    @Override
    public ResponseEntity mineBlock() throws NoSuchAlgorithmException {
        return ResponseEntity.ok().body(blockchainService.mineBlock());
    }
}
