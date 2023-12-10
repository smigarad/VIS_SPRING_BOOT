package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product_Size {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column
    private int size;

//    one product can have many sizes
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product_Size() {
    }

    public Product_Size(int size) {
        this.size = size;
    }
}
