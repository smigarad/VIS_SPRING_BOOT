package java1_2023_smi0132.Resources;

import java1_2023_smi0132.Models.OrderEntity;
import java1_2023_smi0132.Models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    public Payment findPaymentByOrder(OrderEntity orderEntity);
}
