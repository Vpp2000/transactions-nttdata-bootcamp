package com.example.transactions_ms.repository;

import com.example.transactions_ms.documents.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
