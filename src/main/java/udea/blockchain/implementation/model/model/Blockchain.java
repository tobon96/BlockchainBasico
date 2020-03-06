package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Getter
@Setter
public class Blockchain {

    private static int difficulty;
    private static ArrayList<Transaction> transactions;
    private ArrayList<Block> blockchain;
    private int transactionLimit;
    private double mine;
    private static Blockchain singleton;

    private Blockchain(Block genesis) {
        this.blockchain = new ArrayList<Block>();
        this.blockchain.add(genesis);
    }

    public static Blockchain getInstance() {
        if (singleton == null) {
            Block genesisBlock = new Block(difficulty);
            transactions = new ArrayList<Transaction>();
            singleton = new Blockchain(genesisBlock);
        }
        return singleton;
    }

    public static ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public static void setDifficulty(int newDifficulty) {
        difficulty = newDifficulty;
    }

    public static int getDifficulty() {
        return difficulty;
    }

    public String computeHash(Block block) throws NoSuchAlgorithmException, NoSuchAlgorithmException {
        String textToHash = block.toString();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(textToHash.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String proof(Block block) throws NoSuchAlgorithmException {
        String target = new String(new char[difficulty]).replace('\0', '0');
        String hash = computeHash(block);
        while (!hash.substring(0, difficulty).equals(target)) {
            block.getHeader().setNonce(block.getHeader().getNonce() + 1);
            hash = computeHash(block);
        }

        return hash;
    }
}
