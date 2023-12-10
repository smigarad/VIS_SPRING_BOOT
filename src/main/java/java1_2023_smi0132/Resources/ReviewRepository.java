package java1_2023_smi0132.Resources;

import java1_2023_smi0132.Models.Product;
import java1_2023_smi0132.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findAllByProduct(Product product);
}
