package com.example.transactions_ms.repository;

import com.example.transactions_ms.documents.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
    Flux<Transaction> findByProductIdAndCustomerId(String productId, String customerId);
}
