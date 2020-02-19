package udea.blockchain.implementation.model;

import lombok.Getter;
import lombok.Setter;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

@Getter
@Setter
public class Blockchain {

    private ArrayList<Block> blockchain;
    private static Blockchain singleton;

    private Blockchain(Block genesis) {
        this.blockchain = new ArrayList<Block>();
        this.blockchain.add(genesis);
    }

    public static Blockchain getInstance() throws NoSuchAlgorithmException {
        if(singleton == null) {
            Block genesisBlock = new Block();
            genesisBlock.computeHash();
            singleton = new Blockchain(genesisBlock);
        }

        return singleton;
    }
}
