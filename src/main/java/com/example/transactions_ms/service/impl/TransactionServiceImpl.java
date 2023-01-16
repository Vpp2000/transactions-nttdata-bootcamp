package com.example.transactions_ms.service.impl;

import com.example.transactions_ms.documents.Transaction;
import com.example.transactions_ms.repository.TransactionRepository;
import com.example.transactions_ms.service.TransactionService;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private static final Logger logs_to_file = Logger.getLogger("debugger_file");

    @Override
    public Flux<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Mono<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Mono<Transaction> save(Transaction transaction) {
        logs_to_file.info(String.format("Saving transaction of customerId {}", transaction.getCustomerId()));
        return transactionRepository.save(transaction);
    }

    @Override
    public Mono<Transaction> update(Transaction transaction, String id) {
        Mono<Transaction> currentTransactionMono = transactionRepository.findById(id);
        return currentTransactionMono.flatMap(currentTransactionType -> {
            transaction.setId(id);
            return transactionRepository.save(transaction);
        });
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return transactionRepository.deleteById(id);
    }


    @Override
    public Flux<Transaction> getOperationsFromAccount(String productId, String customerId){
        Logger.getLogger("root").info(String.format("productId: %s customerId: %s", productId, customerId));
        Flux<Transaction> transactionsFlux = transactionRepository.findByProductIdAndCustomerId(productId, customerId);
        return transactionsFlux;
    }
}
