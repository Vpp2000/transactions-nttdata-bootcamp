package com.example.transactions_ms.documents;

import com.example.transactions_ms.enums.ProductType;
import com.example.transactions_ms.enums.TransactionType;
import java.util.Date;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="transactions")
public class Transaction {
    @Id
    private String id;
    private ProductType productType;  // AHORRO, C_CORRIENTE, PLAZO_FIJO, CRE_PERSONAL, CRED_EMPRESARIAL, TAR_CRED_PERSONAL, TAR_CRED_EMPRESARIAL
    private String productId;
    private String customerId;
    private TransactionType transactionType;  // DEPOSITO, RETIRO, PAGO, CONSUMO
    private Double amount;
    private Date transactionDate;
}
