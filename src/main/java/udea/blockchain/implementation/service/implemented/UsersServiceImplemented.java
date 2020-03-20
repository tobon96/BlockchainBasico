package udea.blockchain.implementation.service.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.model.User;
import udea.blockchain.implementation.repository.UsersRepository;
import udea.blockchain.implementation.service.UsersService;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UsersServiceImplemented implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public User saveUser(String usertype) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        User user = new User(keyPair.getPublic().getEncoded(), keyPair.getPrivate().getEncoded(), usertype);
        usersRepository.save(user);
        return user;
    }

    @Override
    public User createMine(double balance) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        User user = new User(keyPair.getPublic().getEncoded(), keyPair.getPrivate().getEncoded(), balance);
        usersRepository.save(user);
        return user;
    }

    @Override
    public List<User> listUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User findUser(String userKey) {
        return usersRepository.findByPublicKey(userKey);
    }


}
