package java1_2023_smi0132.Controllers;

import java1_2023_smi0132.Models.User;
import java1_2023_smi0132.Services.CartService;
import java1_2023_smi0132.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@SessionAttributes("loggedInUser")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/cart")
    public String showCart(Model model, HttpSession session){
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        model.addAttribute("title", "Cart");
        model.addAttribute("cart", loggedInUser.getCart());
        return "cart";
    }

    @PostMapping("/removeProductFromCart")
    public String removeProductFromCart(@RequestParam("productId") int productId,Model mode,
                                        HttpSession session){
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        cartService.removeProductFromCart(loggedInUser.getCart().getId(), productId);
        loggedInUser = userService.getUserById(loggedInUser.getId());
        session.setAttribute("loggedInUser", loggedInUser);
        // Logic to remove the product from the cart
        return "redirect:/cart";
    }

    @PostMapping("/flushCart")
    public String flushCart(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        cartService.flushCart(loggedInUser.getCart().getId());
        loggedInUser = userService.getUserById(loggedInUser.getId());
        session.setAttribute("loggedInUser", loggedInUser);
        return "redirect:/cart";
    }
}
