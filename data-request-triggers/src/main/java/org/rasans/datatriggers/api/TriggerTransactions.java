package org.rasans.datatriggers.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.rasans.transactionsgenerator.generators.BulkTransactionGenerator.generateTransaction;

public class TriggerTransactions {
    public static void main(String[] args) {
        int recordCount = 1000000;
        List<Map<String, Object>> transactions = new ArrayList<>();
        for (int i = 0; i < recordCount; i++) {
            transactions.add(generateTransaction());
        }

        System.out.println("number of records generated : "+transactions.size());
    }
}