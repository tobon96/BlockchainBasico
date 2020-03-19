package udea.blockchain.implementation.service.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.model.Block;
import udea.blockchain.implementation.model.model.Blockchain;
import udea.blockchain.implementation.model.model.Transaction;
import udea.blockchain.implementation.model.model.User;
import udea.blockchain.implementation.model.request.ConfigurationRequest;
import udea.blockchain.implementation.model.response.ConfigurationResponse;
import udea.blockchain.implementation.service.ConfigurationService;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@Service
public class ConfigurationServiceImplemented implements ConfigurationService {

    @Autowired
    private UsersServiceImplemented usersServiceImplemented;

    @Override
    public ConfigurationResponse setConfig(ConfigurationRequest request) throws NoSuchAlgorithmException {
        Blockchain.setDifficulty(request.getDifficulty().orElse(3));
        Blockchain.getInstance().setTransactionLimit(request.getTransactionLimit().orElse(3));

        if(request.getMaximumTokens().isPresent()) {
            Blockchain.getInstance().setMine(request.getMaximumTokens().getAsDouble());
            User mine = usersServiceImplemented.createMine(request.getMaximumTokens().getAsDouble());
            User firstMiner = usersServiceImplemented.saveUser("miner");
            Transaction primitiveTransaction = new Transaction(mine.getPublicKey(), 25, firstMiner.getPublicKey());
            ArrayList<Transaction> primitiveArray = new ArrayList<Transaction>();
            primitiveArray.add(primitiveTransaction);
            Block genesisBlock = new Block(Blockchain.getDifficulty(), primitiveArray);
            Blockchain.getInstance().getBlockchain().add(genesisBlock);
            genesisBlock.getHeader().setHash(Blockchain.proof(genesisBlock));
        }

        return new ConfigurationResponse(Blockchain.getDifficulty() ,Blockchain.getInstance().getTransactionLimit(), Blockchain.getInstance().getMine(), "Configuration updated successfully");
    }
}
