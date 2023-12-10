package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private float amount;
    private int status;
    private Date date_of_payment;
    private int type;
    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    public Payment() {
    }

    public Payment(float amount, int status, Date date_of_payment, int type, OrderEntity order) {
        this.amount = amount;
        this.status = status;
        this.date_of_payment = date_of_payment;
        this.type = type;
        this.order = order;
    }

}
