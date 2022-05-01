package store.business;

import store.domain.Customer;
import store.domain.DeliveryPriority;
import store.domain.OrderHeader;
import store.domain.OrderLine;
import store.integration.PaymentGateway;

import java.util.List;

public class OrderController {

    private DeliveryCalculator deliveryCalculator;
    private PaymentGateway paymentGateway;

    public OrderController() {
    }

    public OrderHeader createOrder(Customer customer) {
        return new OrderHeader(customer);
    }

    public void processOrder(OrderHeader order) {
        if (!validateOrder(order)) {
            throw new IllegalStateException("Order validation failed - customers under 18 cannot buy restricted items.");
        }

        double deliveryFee = deliveryCalculator.calculateDelivery(order);
        order.setDeliveryFee(deliveryFee);

        paymentGateway.processPayment(order.getCustomer(), order.getOrderTotal() + deliveryFee);
    }

    protected boolean validateOrder(OrderHeader order) {
        int customerAge = order.getCustomer().getAge();

        if (customerAge <= 18 && order.hasRestrictedItems()) {
            return false;
        }

        return true;
    }

    //Here, our setters are a rudimentary form of dependency injection.
    public void setDeliveryCalculator(DeliveryCalculator deliveryCalculator) {
        this.deliveryCalculator = deliveryCalculator;
    }

    public void setPaymentGateway(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
