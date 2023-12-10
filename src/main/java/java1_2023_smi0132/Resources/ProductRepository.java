package java1_2023_smi0132.Resources;


import java1_2023_smi0132.Models.Manufacturer;
import java1_2023_smi0132.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public List<Product> findProductsByManufacturer(Manufacturer manufacturer);
    @Query("SELECT p FROM Product p JOIN p.categories c WHERE c.id = :categoryId")
    List<Product> findAllByCategoryId(@Param("categoryId") Integer categoryId);
}
