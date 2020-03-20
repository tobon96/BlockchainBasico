package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Getter
@Setter
@Document(collection = "blocks")
public class Block {

    @Id
    private String id;
    private BlockHeader header;
    private BlockBody body;

    public Block(int difficulty, ArrayList<Transaction> transactions) {
        this.header = new BlockHeader(difficulty);
        this.body = new BlockBody(transactions);
    }

    public Block(BlockHeader header, BlockBody body) {
        this.header = header;
        this.body = body;
    }
}
