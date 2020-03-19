package udea.blockchain.implementation.service;

import udea.blockchain.implementation.model.model.Transaction;

public interface TransactionsService {

    Transaction addTransaction(Transaction transaction) throws Exception;
}
