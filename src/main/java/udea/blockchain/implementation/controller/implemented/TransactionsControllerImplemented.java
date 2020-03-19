package udea.blockchain.implementation.controller.implemented;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import udea.blockchain.implementation.controller.TransactionsController;
import udea.blockchain.implementation.model.model.Transaction;
import udea.blockchain.implementation.model.response.ErrorResponse;
import udea.blockchain.implementation.service.implemented.TransactionsServiceImplemented;

@RestController
public class TransactionsControllerImplemented implements TransactionsController {

    @Autowired
    private TransactionsServiceImplemented transactionsServiceImplemented;

    @Override
    public ResponseEntity addTransaction(Transaction request) throws Exception{
        try {
            return ResponseEntity.accepted().body(transactionsServiceImplemented.addTransaction(request));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorResponse("Superó la cantidad máxima de transacciones, hora de minar"));
        }

    }
}
