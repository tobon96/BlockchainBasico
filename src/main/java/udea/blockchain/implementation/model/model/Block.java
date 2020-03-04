package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Block {
    private BlockHeader header;
    private BlockBody body;

    public Block(String previousHash, String data) {

    }

    public Block() {

    }

    /*
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

     */
}
