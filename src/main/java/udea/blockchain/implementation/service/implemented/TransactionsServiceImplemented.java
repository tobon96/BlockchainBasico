package udea.blockchain.implementation.service.implemented;

import org.springframework.stereotype.Service;
import udea.blockchain.implementation.model.model.Blockchain;
import udea.blockchain.implementation.model.model.Transaction;
import udea.blockchain.implementation.service.TransactionsService;

@Service
public class TransactionsServiceImplemented implements TransactionsService {
    @Override
    public Transaction addTransaction(Transaction transaction) throws Exception {
        if(Blockchain.getTransactions().size() < Blockchain.getInstance().getTransactionLimit()){
            Blockchain.getTransactions().add(transaction);
            return transaction;
        }
        throw  new Exception();
    }
}
