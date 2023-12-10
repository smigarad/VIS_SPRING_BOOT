package java1_2023_smi0132.Controllers;

import java1_2023_smi0132.Models.*;
import java1_2023_smi0132.Services.CategoryService;
import java1_2023_smi0132.Services.ManufacturerService;
import java1_2023_smi0132.Services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
//@SessionAttributes("loggedInUser")
public class CatalogController {

    private final CategoryService categoryService;
    private final ProductService productService;
    private final ManufacturerService manufacturerService;

    @Autowired
    public CatalogController(CategoryService categoryService, ProductService productService, ManufacturerService manufacturerService) {
        this.categoryService = categoryService;
        this.productService = productService;
        this.manufacturerService = manufacturerService;
    }
    @GetMapping("/catalog")
    public String showCatalog(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        model.addAttribute("title", "Catalog");
        System.out.println("loggedInUser: " + loggedInUser);
        int cartNumber = loggedInUser.getCart().getQuantity();
        System.out.println("cartNumber: " + cartNumber);
        model.addAttribute("cartNumber", cartNumber);
//        model.addAttribute("products",Product)
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        model.addAttribute("products", productService.getAllProducts());
        return "catalog";

    }

    @GetMapping("/products")
    public String filterProducts(@RequestParam(required = false) Integer categoryId,
                                 @RequestParam(required = false) Integer manufacturerId,
                                 Model model,HttpSession session){

        List<Product> products;

        if (categoryId != null && manufacturerId != null) {
            Category category = categoryService.getCategoryById(categoryId);
            Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
            products = productService.getProductsByCategoryAndManufacturer(category, manufacturer);
        } else if (categoryId != null) {
            Category category = categoryService.getCategoryById(categoryId);
            products = productService.getProductsByCategory(category);
        } else if (manufacturerId != null) {
            Manufacturer manufacturer = manufacturerService.getManufacturerById(manufacturerId);
            products = productService.getProductsByManufacturer(manufacturer);
        } else {
            products = productService.getAllProducts();
        }

        model.addAttribute("products", products);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturers());
        model.addAttribute("cartNumber", ((User) session.getAttribute("loggedInUser")).getCart().getQuantity());
        return "catalog";
    }

}
