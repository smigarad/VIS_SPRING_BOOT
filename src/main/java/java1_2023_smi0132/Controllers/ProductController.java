package java1_2023_smi0132.Controllers;

import java1_2023_smi0132.Models.Product;
import java1_2023_smi0132.Models.Review;
import java1_2023_smi0132.Models.User;
import java1_2023_smi0132.Services.CartService;
import java1_2023_smi0132.Services.ProductService;
import java1_2023_smi0132.Services.ReviewService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@SessionAttributes("loggedInUser")
public class ProductController {
    private final ProductService productService;
    private final CartService cartService;
    private final ReviewService reviewService;


    @Autowired
    public ProductController(ProductService productService, CartService cartService, ReviewService reviewService) {

        this.productService = productService;
        this.cartService = cartService;
        this.reviewService = reviewService;
    }

    @GetMapping("/product/{id}")
    public String showProductDetails(@PathVariable int id, Model model, HttpSession session){
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        Product product = productService.getProductById(id);
        List<Review> reviews = reviewService.getReviewsByProduct(product);

        model.addAttribute("product", product);
        model.addAttribute("cartNumber", loggedInUser.getCart().getQuantity());
        model.addAttribute("reviews", reviews);
        model.addAttribute("loggedInUser", loggedInUser);
        return "productDetails";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("product_id") int product_id,
                            Model model, HttpSession session){
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        Product product = productService.getProductById(product_id);
        System.out.println("product: " + product);
//        System.out.println("quantity: " + quantity);
        cartService.addProductToCart(loggedInUser.getCart().getId(), 1, product);
        loggedInUser.setCart(cartService.getCartById(loggedInUser.getCart().getId()));
        model.addAttribute("product", product);
        return "redirect:/product/" + product_id;
    }
    @PostMapping("/addToCartFromCatalog")
    public String addToCartFromCatalog(@RequestParam("product_id") int product_id,
                            Model model, HttpSession session){
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        Product product = productService.getProductById(product_id);
        System.out.println("product: " + product);
//        System.out.println("quantity: " + quantity);
        cartService.addProductToCart(loggedInUser.getCart().getId(), 1, product);
        loggedInUser.setCart(cartService.getCartById(loggedInUser.getCart().getId()));
        model.addAttribute("product", product);
        return "redirect:/catalog";
    }

    @PostMapping("/addReview")
    public String addReview(@RequestParam("productId") int product_id,
                            @RequestParam("description") String description,
                            @RequestParam("rating") int rating,
                            Model model, HttpSession session){
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        Product product = productService.getProductById(product_id);
        System.out.println("product: " + product);
        reviewService.addReview(loggedInUser, product, description, rating);
        model.addAttribute("product", product);
//        model.addAttribute("loggedInUser", loggedInUser);
        return "redirect:/product/" + product_id;
    }

    @PostMapping("/deleteReview")
    public String deleteReview(@RequestParam("reviewId") int review_id,
                            Model model, HttpSession session){
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        Review review = reviewService.getReviewById(review_id);
        Product product = review.getProduct();
        System.out.println("product: " + product);
        reviewService.deleteReview(review_id);
        model.addAttribute("product", product);
        return "redirect:/product/" + product.getId();
    }
}
