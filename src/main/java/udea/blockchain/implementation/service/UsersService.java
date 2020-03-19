package udea.blockchain.implementation.service;

import udea.blockchain.implementation.model.model.User;

import java.security.NoSuchAlgorithmException;
import java.util.List;


public interface UsersService {
    User saveUser(String userType) throws NoSuchAlgorithmException;

    User createMine(double balance) throws NoSuchAlgorithmException;

    List<User> listUsers();

    User findUser(String userKey);
}
