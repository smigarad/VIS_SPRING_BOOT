package java1_2023_smi0132.Services;

import java1_2023_smi0132.Resources.*;
import java1_2023_smi0132.Models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        products.forEach(System.out::println);
        return products;
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findAllByCategoryId(category.getId());
    }

    public List<Product> getProductsByManufacturer(Manufacturer manufacturer) {
        return productRepository.findProductsByManufacturer(manufacturer);
    }

    public List<Product> getProductsByCategoryAndManufacturer(Category category, Manufacturer manufacturer) {
        List<Product> categoryProducts = getProductsByCategory(category);
        List<Product> manufacturerProducts = getProductsByManufacturer(manufacturer);
        List<Product> products = new ArrayList<>();
        for (Product categoryProduct : categoryProducts) {
            for (Product manufacturerProduct : manufacturerProducts) {
                if (categoryProduct.getId() == manufacturerProduct.getId()) {
                    products.add(categoryProduct);
                }
            }
        }
        return products;
    }
}
