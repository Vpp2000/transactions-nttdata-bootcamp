package com.example.transactions_ms.listeners;

import com.example.transactions_ms.documents.Transaction;
import java.util.Date;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


// CLASE UTILIZADA PARA INSERTAR FECHA DE CREACION DE REGISTRO EN LA BASE DE DATOS
@Component
public class MongoListener extends AbstractMongoEventListener<Transaction> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Transaction> event) {
        super.onBeforeConvert(event);

        Date dateNow = new Date();

        event.getSource().setTransactionDate(dateNow);
    }
}
