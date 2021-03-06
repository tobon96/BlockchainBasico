package udea.blockchain.implementation.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import udea.blockchain.implementation.model.model.User;

public interface UsersRepository extends MongoRepository<User, String> {

    User findByPublicKey(String publicKey);
}
