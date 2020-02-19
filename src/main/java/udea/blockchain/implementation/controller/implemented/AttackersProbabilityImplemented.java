package udea.blockchain.implementation.controller.implemented;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import udea.blockchain.implementation.controller.AttackersProbabilityController;
import udea.blockchain.implementation.model.ProbabilityRequest;
import udea.blockchain.implementation.model.ProbabilityResponse;

@RestController
public class AttackersProbabilityImplemented implements AttackersProbabilityController {

    @Override
    public ResponseEntity<ProbabilityResponse> getProbability(ProbabilityRequest request) {
        ProbabilityResponse response = new ProbabilityResponse();
        response.setProbability(0.0);
        return ResponseEntity.ok().body(response);
    }
}
