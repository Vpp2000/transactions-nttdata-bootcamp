package com.example.transactions_ms.service.impl;

import com.example.transactions_ms.documents.Transaction;
import com.example.transactions_ms.repository.TransactionRepository;
import com.example.transactions_ms.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

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

}
