package udea.blockchain.implementation.service;

import udea.blockchain.implementation.model.model.Block;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public interface BlockchainService {

    ArrayList<Block> getBlockchain();

    Block mineBlock() throws NoSuchAlgorithmException;
}
