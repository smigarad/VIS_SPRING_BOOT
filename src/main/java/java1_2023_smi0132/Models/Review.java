package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "review")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private int rating;

    @Column(name = "date_of_review")
    private Date date_of_review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Review() {
    }

    public Review(String description, int rating, Date date_of_review, User user, Product product) {
        this.description = description;
        this.rating = rating;
        this.date_of_review = date_of_review;
        this.user = user;
        this.product = product;
    }
}
