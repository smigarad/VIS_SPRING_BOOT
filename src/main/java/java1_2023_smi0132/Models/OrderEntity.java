package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "OrderEntity")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    private Date date_of_order;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int status;

//    @ManyToMany
//    @JoinTable(
//            name = "Order_Product",
//            joinColumns = @JoinColumn(name = "order_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private List<Product> products;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;
    public OrderEntity() {
    }

    public OrderEntity(Date date_of_order, User user, int status) {
        this.date_of_order = date_of_order;
        this.user = user;
        this.status = status;
    }
}
