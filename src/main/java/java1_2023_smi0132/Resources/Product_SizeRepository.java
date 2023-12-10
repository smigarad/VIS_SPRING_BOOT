package java1_2023_smi0132.Resources;

import java1_2023_smi0132.Models.Product;
import java1_2023_smi0132.Models.Product_Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Product_SizeRepository extends JpaRepository<Product_Size, Integer> {

    public List<Product_Size> findProduct_SizeByProduct(Product product);
}
