package java1_2023_smi0132.Resources;

import java1_2023_smi0132.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
//    public List<Category> findByProduct(Product product);
}
