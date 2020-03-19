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
    private int height;
    private String hash;

    public BlockHeader(int difficulty) {
        this.difficulty = difficulty;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.previousHash = "0";
        this.nonce = 0;
        this.height = 0;
    }

    public BlockHeader(String previousHash, String merkleRoot, int difficulty, int height) {
        this.previousHash = previousHash;
        nonce = 0;
        this.merkleRoot = merkleRoot;
        this.difficulty = difficulty;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.height = height;
    }
}
