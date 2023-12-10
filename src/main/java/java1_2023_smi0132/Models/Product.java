package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
//@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private int gender;
    @Column
    private float price;
    @Column
    private int stock_quantity;
    @Column
    private String description;

    @ManyToMany
    @JoinTable(
            name = "Product_Category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;
    public Product() {
    }

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
    public Product(String name, int gender, float price, int stock_quantity, String description){
        this.name = name;
        this.gender = gender;
        this.price = price;
        this.stock_quantity = stock_quantity;
        this.description = description;
    }


}
