package store.business;

import store.domain.OrderHeader;

public interface DeliveryCalculator {

    double calculateDelivery(OrderHeader order);
}
