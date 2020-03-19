package udea.blockchain.implementation.model.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.*;

@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    private String id;
    private byte[] publicKey;
    private byte[] privateKey;
    private String userType;
    private double balance;

    public User(byte[] publicKey, byte[] privateKey, double balance) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        userType = "mine";
        this.balance = balance;
    }

    public User(byte[] publicKey, byte[] privateKey, String userType) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        this.userType = userType;
        balance = 0;
    }

    public User(){}


}
