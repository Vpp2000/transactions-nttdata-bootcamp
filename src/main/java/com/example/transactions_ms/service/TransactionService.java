package com.example.transactions_ms.service;

import com.example.transactions_ms.documents.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    Flux<Transaction> findAll();
    Mono<Transaction> findById(String id);
    Mono<Transaction> save(Transaction transaction);
    Mono<Transaction> update(Transaction transaction, String id);
    Mono<Void> deleteById(String id);
    Flux<Transaction> getOperationsFromAccount(String productId, String customerId);
}
