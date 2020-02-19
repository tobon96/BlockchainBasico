package udea.blockchain.implementation.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@Getter
@Setter
public class Block {
    private String previousHash;
    private int nonce;
    private String hash;
    private Timestamp timestamp;
    private String data;

    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.data = data;
        this.nonce = 0;
    }

    public Block() {
        this.data = "Genesis block";
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    public void computeHash() throws NoSuchAlgorithmException {
        String textToHash = data + timestamp + nonce + previousHash;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(textToHash.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        this.hash = sb.toString();
    }

    public void proof(int difficulty) throws NoSuchAlgorithmException {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(target)) {
            nonce ++;
            computeHash();
        }

    }
}
