package com.alechoskins.RecipeSharingApi.database;

import org.hibernate.Interceptor;
import org.hibernate.Transaction;

public class HibernateInterceptor implements Interceptor{

    @Override
    public void beforeTransactionCompletion(Transaction tx) {
        System.out.println("Before Transaction Completion");
    }
        //todo make migrations here, maybe. Or use a logger to write to an xml file

}
