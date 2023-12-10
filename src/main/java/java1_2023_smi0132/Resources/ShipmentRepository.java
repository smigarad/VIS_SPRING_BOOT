package java1_2023_smi0132.Resources;


import java1_2023_smi0132.Models.OrderEntity;
import java1_2023_smi0132.Models.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
    public Shipment findShipmentByOrder(OrderEntity order);
//    public Address findAddressByShipment(Shipment shipment);
}
