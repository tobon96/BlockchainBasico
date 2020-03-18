package udea.blockchain.implementation.controller.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import udea.blockchain.implementation.controller.UsersController;
import udea.blockchain.implementation.model.model.User;
import udea.blockchain.implementation.model.response.UsersListResponse;
import udea.blockchain.implementation.service.implemented.UsersServiceImplemented;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class UsersControllerImplemented implements UsersController {

    @Autowired
    private UsersServiceImplemented usersService;

    @Override
    public ResponseEntity<User> createUser() throws NoSuchAlgorithmException {
        return ResponseEntity.accepted().body(usersService.saveUser());
    }

    @Override
    public ResponseEntity<List<UsersListResponse>> listUsers() {
        return null;
    }
}
