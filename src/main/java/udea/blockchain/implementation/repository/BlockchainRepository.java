package udea.blockchain.implementation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import udea.blockchain.implementation.model.model.Block;

public interface BlockchainRepository extends MongoRepository<Block, String> {
}
