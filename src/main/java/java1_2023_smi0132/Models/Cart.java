package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "totalPrice")
    private float totalPrice;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Product_cart",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;

    public Cart() {
    }

    public Cart(float totalPrice, int quantity) {
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }
}
