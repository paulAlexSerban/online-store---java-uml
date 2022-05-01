# Requirements

- software to process orders for an online retailer
- the system will deal with a number of domain entities - including items, orders and customers
- the sold items will fall into user-defined categories - some categories such as liquor, are flagged as being restricted - customer under the age of 18 are not allowed to buy restricted items, and the system should rise an exception if they attempt to
- in addition, we have to maintain certain details of all items - such as the item name, description, price, and category
- we also need to maintain details on our customers - including names, email addresses, and age
- each customer has to have an address, to be using fo billing and delivery
- customers can change their details whenever they want
- when a customer places an order, we'll get the delivery address for the order from the customer
- based on delivery priority and distance from the warehouse, the system will calculate a delivery fee - orders for more than 50$ qualify for free delivery, at normal priority - overnight delivery is charged a fixed rate of $75
- orders consist of two parts
  - first, an order header, identified by an order ID, which maintains a reference to the customer who placed the order, the total cost of items, the delivery fee, and the order rate
  - secondly, a collection of order lines; each line refers to one item on the order, the quality of items ordered, and the total cost of the line
- an order cannot be create without a customer
- in order to process payments from the customers, we will integrate the system with two payment gateways
  - first is straightforward credit card gateway
  - second is a cryptocurrency payment gateway
  - the credit card payment is access via third-party protocol running on a specific server ona specific port, ad requires that we authenticate ourselves prior to each request
  - the cryptocurrency gateway is a HTTP endpoint that requires an API key to be specified with each request
  - from the systems point of view, however, it should not know about details of the particular payment gateway that is being used at any point in time
- teh system should be able to generate sales reports for the CFO
- sales reports will include all orders within a given date range
- sales reports are displayed after being generated

## Summary

- store item details
- store item categories
- store customer details
- store order details
- disallow illegal orders
- calculate delivery fees
- process payments
- generate sales reports
