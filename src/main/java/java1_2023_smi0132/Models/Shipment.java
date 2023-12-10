package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Shipment")
public class Shipment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private int status;
    private Date date_of_shipment;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Shipment() {
    }

    public Shipment(int status, Date date_of_shipment, OrderEntity order, Address address) {
        this.status = status;
        this.date_of_shipment = date_of_shipment;
        this.order = order;
        this.address = address;
    }

}
