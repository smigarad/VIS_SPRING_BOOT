package java1_2023_smi0132.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street")
    private String street;
    @Column(name = "city")
    private String city;
    @Column(name="country")
    private String country;
    @Column(name="postalCode")
    private int postalCode;

    public Address() {
    }

    public Address(String street, String city, String country, int postalCode) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }


}
