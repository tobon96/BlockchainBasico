package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

@Getter
@Setter
@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private String publicKey;
    private String privateKey;
    private double balance;
    private final KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

    public User() throws NoSuchAlgorithmException {
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        publicKey = keyPair.getPublic().toString();
        privateKey = keyPair.getPrivate().toString();
        balance = 0;
    }
}
