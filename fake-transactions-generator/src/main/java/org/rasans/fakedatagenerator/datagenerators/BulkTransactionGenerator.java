package org.rasans.fakedatagenerator.datagenerators;

import com.github.javafaker.Faker;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class BulkTransactionGenerator {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();
    private static final String[] productIds = {"product1", "product2", "product3", "product4", "product5", "product6"};
    private static final String[] productNames = {"laptop", "mobile", "tablet", "watch", "headphone", "speaker"};
    private static final String[] productCategories = {"electronic", "fashion", "grocery", "home", "beauty", "sports"};
    private static final String[] brands = {"apple", "samsung", "oneplus", "mi", "boat", "sony"};
    private static final String[] currencies = {"USD", "GBP"};
    private static final String[] paymentMethods = {"credit_card", "debit_card", "online_transfer"};

    private static String randomChoice(String[] array) {
        return array[random.nextInt(array.length)];
    }

    public static Map<String, Object> generateTransaction() {
        Map<String, Object> transaction = new HashMap<>();

        transaction.put("transactionId", UUID.randomUUID().toString());
        transaction.put("productId", randomChoice(productIds));
        transaction.put("productName", randomChoice(productNames));
        transaction.put("productCategory", randomChoice(productCategories));
        transaction.put("productPrice", Math.round((10 + 990 * random.nextDouble()) * 100.0) / 100.0);
        transaction.put("productQuantity", random.nextInt(10) + 1);
        transaction.put("productBrand", randomChoice(brands));
        transaction.put("currency", randomChoice(currencies));
        transaction.put("customerId", faker.name().username());
        transaction.put("transactionDate", ZonedDateTime.now(ZoneOffset.UTC)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")));
        transaction.put("paymentMethod", randomChoice(paymentMethods));

        return transaction;
    }
}
