package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "Category")
public class Category {
    @Column(name = "name")
    private String name;

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;
    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

}
