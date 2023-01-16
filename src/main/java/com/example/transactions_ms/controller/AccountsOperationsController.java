package com.example.transactions_ms.controller;

import com.example.transactions_ms.documents.Transaction;
import com.example.transactions_ms.dto.AccountOperationsRequest;
import com.example.transactions_ms.service.TransactionService;
import java.util.logging.Logger;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;


// CONTROLADOR USADO PARA LA CONSULTA DE LAS OPERACIONES DE UN PRODUCTO
@RestController
@RequiredArgsConstructor
public class AccountsOperationsController {

    private final TransactionService transactionService;

    @GetMapping("/account/{productId}/operations")
    public Flux<Transaction> getAccountOperations(@PathVariable String productId,@RequestBody AccountOperationsRequest accountOperationsRequest){
        Logger.getLogger("root").info(String.format("productId: %s customerId: %s", productId, accountOperationsRequest.getCustomerId()));
        return transactionService.getOperationsFromAccount(productId, accountOperationsRequest.getCustomerId());
    }
}
