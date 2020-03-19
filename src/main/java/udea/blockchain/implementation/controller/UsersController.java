package udea.blockchain.implementation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.blockchain.implementation.model.model.User;
import udea.blockchain.implementation.model.request.UserCreationRequest;
import udea.blockchain.implementation.model.response.UsersListResponse;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@CrossOrigin
@RequestMapping("/api")
public interface UsersController {

    @PostMapping(value = "/create-user", produces = "application/json")
    ResponseEntity<User> createUser(@RequestBody UserCreationRequest userCreationRequest) throws NoSuchAlgorithmException;

    @GetMapping(value = "/list-users", produces = "application/json")
    ResponseEntity<List<User>> listUsers();

    @GetMapping(value = "/find-user", produces = "application/json")
    ResponseEntity<User> findUser(@RequestParam String request);
}
