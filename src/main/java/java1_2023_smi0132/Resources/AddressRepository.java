package java1_2023_smi0132.Resources;

import java1_2023_smi0132.Models.Address;
import java1_2023_smi0132.Models.Shipment;
import java1_2023_smi0132.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query("SELECT a FROM User user JOIN Address a ON user.address.id = a.id WHERE user = ?1")
    public Address findAddressByUser(User user);
    @Query("SELECT s.address FROM Shipment s WHERE s = :shipment")
    public Address findAddressByShipment(@Param("shipment") Shipment shipment);

}
