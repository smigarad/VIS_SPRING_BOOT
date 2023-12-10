package java1_2023_smi0132.Resources;

import java1_2023_smi0132.Models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Integer> {

}
