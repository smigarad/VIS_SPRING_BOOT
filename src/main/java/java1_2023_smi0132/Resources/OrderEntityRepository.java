package java1_2023_smi0132.Resources;

import java1_2023_smi0132.Models.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRepository extends JpaRepository<OrderEntity, Integer> {



}
