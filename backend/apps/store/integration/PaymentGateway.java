package store.integration;

import store.domain.Customer;

public interface PaymentGateway {

    void processPayment(Customer customer, double amount);
}
