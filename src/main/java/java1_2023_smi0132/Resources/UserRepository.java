package java1_2023_smi0132.Resources;

import java1_2023_smi0132.Models.Address;
import java1_2023_smi0132.Models.Cart;
import java1_2023_smi0132.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



    public User findUserByAddress(Address address);
    public User findUserByEmail(String email);
    @Query("SELECT u FROM User u JOIN OrderEntity oe ON u.id = oe.user.id WHERE oe.id = :orderId")
    public User findUserByOrderEntity(@Param("orderId") int orderId);

    public User findUserByCart(Cart cart);
    public User findUserByEmailAndPassword(String email, String password);
    public User findUserById(int id);
}
