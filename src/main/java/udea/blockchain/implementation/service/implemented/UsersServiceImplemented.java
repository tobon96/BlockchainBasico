package udea.blockchain.implementation.service.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.model.User;
import udea.blockchain.implementation.repository.BlockchainRepository;
import udea.blockchain.implementation.service.UsersService;

import java.security.NoSuchAlgorithmException;

@Service
public class UsersServiceImplemented implements UsersService {

    @Autowired
    BlockchainRepository usersRepository;

    public User saveUser() throws NoSuchAlgorithmException {
        User user = new User();
        System.out.println(user.getPublicKey());
        System.out.println(user.getPrivateKey());
        //usersRepository.save(user);
        return user;
    }
}
