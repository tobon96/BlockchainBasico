package udea.blockchain.implementation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udea.blockchain.implementation.model.ProbabilityRequest;
import udea.blockchain.implementation.model.ProbabilityResponse;


@CrossOrigin
@RequestMapping("/api")
public interface AttackersProbabilityController {

    @PostMapping(value = "/precise", consumes = "application/json", produces = "application/json")
    ResponseEntity<ProbabilityResponse> getProbability(@RequestBody ProbabilityRequest request);
}
