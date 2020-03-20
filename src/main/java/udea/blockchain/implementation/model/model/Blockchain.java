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

    private Blockchain() {
        this.blockchain = new ArrayList<>();
    }

    public static Blockchain getInstance() {
        if (singleton == null) {
            transactions = new ArrayList<>();
            singleton = new Blockchain();
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

    private static String computeHash(String stringToHash) throws NoSuchAlgorithmException {
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(stringToHash.getBytes(StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    private static String getStringToHash(Block block) {

        return block.getHeader().getPreviousHash() + block.getHeader().getMerkleRoot() + block.getHeader().getNonce() +
                block.getHeader().getDifficulty() + block.getHeader().getHeight() + block.getHeader().getTimestamp() + block.getBody().getTransactions();
    }

    public static String proof(Block block) throws NoSuchAlgorithmException {
        String target = new String(new char[difficulty]).replace('\0', '0');
        String hash = computeHash(getStringToHash(block));
        while (!hash.substring(0, difficulty).equals(target)) {
            block.getHeader().setNonce(block.getHeader().getNonce() + 1);
            hash = computeHash(getStringToHash(block));
        }

        return hash;
    }
    
    public static String createMerkleTree(ArrayList<Transaction> transactions) throws NoSuchAlgorithmException {
        ArrayList<String> hashList = new ArrayList<>();
        for (Transaction transaction: transactions) {
            hashList.add(transaction.toString());
        }

        ArrayList<String> merkleTree = merkleTree(hashList);
        return merkleTree.get(0);
    }

    private static ArrayList<String> merkleTree(ArrayList<String> hashList) throws NoSuchAlgorithmException {
        
        //Return the Merkle Root
        if(hashList.size() == 1){
            hashList.add(computeHash(hashList.get(0)));
            return hashList;
        }
        ArrayList<String> parentHashList = new ArrayList<>();
        //Hash the leaf transaction pair to get parent transaction
        for(int i=0; i<hashList.size(); i+=2){
            String hashedString = computeHash(hashList.get(i).concat(hashList.get(i+1)));
            parentHashList.add(hashedString);
        }
        // If odd number of transactions , add the last transaction again
        if(hashList.size() % 2 == 1){
            String lastHash=hashList.get(hashList.size()-1);
            String hashedString = computeHash(lastHash.concat(lastHash));
            parentHashList.add(hashedString);
        }
        return merkleTree(parentHashList);
    }
}
