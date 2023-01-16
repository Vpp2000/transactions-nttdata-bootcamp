package com.example.transactions_ms.dto;

import lombok.Data;

// CLASE USADA COMO REQUEST BODY PARA LA CONSULTA DE OPERACIONES DE PRODUCTO
@Data
public class AccountOperationsRequest {
    private String customerId;
}
