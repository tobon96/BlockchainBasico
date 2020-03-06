package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Getter
@Setter
public class Block {
    private BlockHeader header;
    private BlockBody body;

    public Block(int difficulty) {
        this.header = new BlockHeader(difficulty);
        this.body = new BlockBody();
    }

    public Block(ArrayList<Transaction> transactions, int difficulty) {

    }




    /*


     */
}
