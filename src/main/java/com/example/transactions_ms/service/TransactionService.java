package com.example.transactions_ms.service;

import com.example.transactions_ms.documents.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransactionService {
    public Flux<Transaction> findAll();

    public Mono<Transaction> findById(String id);

    public Mono<Transaction> save(Transaction transaction);

    public Mono<Transaction> update(Transaction transaction, String id);

    public Mono<Void> deleteById(String id);

}
