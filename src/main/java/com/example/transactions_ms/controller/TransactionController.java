package com.example.transactions_ms.controller;

import com.example.transactions_ms.documents.Transaction;
import com.example.transactions_ms.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionService transactionService;

    @GetMapping
    public Mono<ResponseEntity<Flux<Transaction>>> findAll() {
        LOGGER.info("Retrieving all transactions");
        return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(transactionService.findAll()));
    }

    @PostMapping
    public Mono<ResponseEntity<Transaction>> save(@RequestBody Transaction transaction){
        return transactionService.save(transaction).map(trans -> ResponseEntity.status(201).body(trans));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable String id){
        return transactionService.deleteById(id).map(trans -> new ResponseEntity<Void>(HttpStatus.OK));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Transaction>> update(@RequestBody Transaction transaction, @PathVariable("id") String id){
        return transactionService.update(transaction, id).map(trans -> ResponseEntity.status(201).body(trans));
    }

}
