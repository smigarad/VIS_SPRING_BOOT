package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Manufacturer")
public class Manufacturer {
    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;

    public Manufacturer() {
    }
    public Manufacturer(String name) {
        this.name = name;
    }
}
