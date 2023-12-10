package java1_2023_smi0132.Resources;

import java1_2023_smi0132.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
//    public Cart findByUser(User user);

}
