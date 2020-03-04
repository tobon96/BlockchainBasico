package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class BlockHeader {
    private String previousHash;
    private String nonce;
    private String merkleRoot;
    private int difficulty;
    private Timestamp timestamp;
}
