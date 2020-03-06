package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BlockHeader {
    private String previousHash;
    private int nonce;
    private String merkleRoot;
    private int difficulty;
    private Timestamp timestamp;

    public BlockHeader(int difficulty) {
        this.difficulty = difficulty;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.previousHash = "0";
        this.nonce = 0;
    }

    public BlockHeader(String previousHash, int nonce, String merkleRoot, int difficulty) {
        this.previousHash = previousHash;
        this.nonce = nonce;
        this.merkleRoot = merkleRoot;
        this.difficulty = difficulty;
    }
}
