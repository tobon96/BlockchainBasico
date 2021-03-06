package udea.blockchain.implementation.service.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.model.*;
import udea.blockchain.implementation.repository.BlockchainRepository;
import udea.blockchain.implementation.service.BlockchainService;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Service
public class BlockchainServiceImplemented implements BlockchainService {

    @Autowired
    private BlockchainRepository blockchainRepository;

    @Override
    public ArrayList<Block> getBlockchain() {
        return Blockchain.getInstance().getBlockchain();
    }

    @Override
    public Block mineBlock() throws NoSuchAlgorithmException {
        ArrayList<Transaction> transactionsCopy = (ArrayList<Transaction>) Blockchain.getTransactions().clone();
        int height = Blockchain.getInstance().getBlockchain().size() + 1;
        BlockHeader header = new BlockHeader(Blockchain.getInstance().getBlockchain().get(height - 2).getHeader().getHash(), Blockchain.createMerkleTree(transactionsCopy), Blockchain.getDifficulty(), height);
        BlockBody body = new BlockBody(transactionsCopy);
        Block newBlock = new Block(header, body);
        Blockchain.getTransactions().clear();
        String hash = Blockchain.proof(newBlock);
        newBlock.getHeader().setHash(hash);
        Blockchain.getInstance().getBlockchain().add(newBlock);
        blockchainRepository.save(newBlock);
        return newBlock;
    }
}
