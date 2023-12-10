package java1_2023_smi0132.Services;

import java1_2023_smi0132.Resources.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java1_2023_smi0132.Models.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderEntityRepository orderEntityRepository;
    private final PaymentRepository paymentRepository;
    private final ShipmentRepository shipmentRepository;
    private final OrderProductRepository orderProductRepository;

    @Autowired
    public OrderService(OrderEntityRepository orderEntityRepository, PaymentRepository paymentRepository,
                        ShipmentRepository shipmentRepository, OrderProductRepository orderProductRepository) {
        this.orderEntityRepository = orderEntityRepository;
        this.paymentRepository = paymentRepository;
        this.shipmentRepository = shipmentRepository;
        this.orderProductRepository = orderProductRepository;
    }

    @Transactional
    public OrderEntity createOrder(User user, int orderStatus, float paymentAmount, int paymentStatus, int paymentType,
                                                         int shipmentStatus, Address shipmentAddress) {
        // Create Order
        OrderEntity order = new OrderEntity();
        order.setDate_of_order(new Date());
        order.setUser(user);
//        order.setProducts(user.getCart().getProducts());
        order.setStatus(orderStatus);

        OrderEntity savedOrder = orderEntityRepository.save(order);

        // Create Payment
        Payment payment = new Payment(paymentAmount, paymentStatus, new Date(), paymentType, savedOrder);
        // Assuming you have a PaymentRepository or similar
        paymentRepository.save(payment);

        // Create Shipment
        Shipment shipment = new Shipment(shipmentStatus, new Date(), savedOrder, shipmentAddress);
        // Assuming you have a ShipmentRepository or similar
        shipmentRepository.save(shipment);
        for(Product product : user.getCart().getProducts()){
            addProductToOrder(savedOrder, product);
        }

        return savedOrder;
    }

    public void addProductToOrder(OrderEntity order, Product product) {
        OrderProduct orderProduct = new OrderProduct(order, product, 1);
        orderProductRepository.save(orderProduct);
    }

}
