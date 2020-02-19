package udea.blockchain.implementation.controller.implemented;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import udea.blockchain.implementation.controller.AddBlockController;
import udea.blockchain.implementation.model.Block;
import udea.blockchain.implementation.model.Blockchain;
import udea.blockchain.implementation.model.NewBlockRequest;
import udea.blockchain.implementation.model.NewBlockResponse;

import java.security.NoSuchAlgorithmException;

@RestController
public class AddBlockImplemented implements AddBlockController {
    @Override
    public ResponseEntity<NewBlockResponse> addBlock(NewBlockRequest request) throws NoSuchAlgorithmException {

        Blockchain blockchain = Blockchain.getInstance();
        Block block = new Block(blockchain.getBlockchain().get(blockchain.getBlockchain().size()-1).getHash(), request.getTransactionData());
        block.computeHash();
        block.proof(request.getDificulty());
        blockchain.getBlockchain().add(block);
        NewBlockResponse response = new NewBlockResponse();
        response.setHash(block.getHash());
        return ResponseEntity.ok().body(response);
    }
}
