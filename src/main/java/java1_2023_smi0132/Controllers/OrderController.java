package java1_2023_smi0132.Controllers;

import java1_2023_smi0132.Models.Address;
import java1_2023_smi0132.Models.User;
import java1_2023_smi0132.Services.AddressService;
import java1_2023_smi0132.Services.CartService;
import java1_2023_smi0132.Services.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private final OrderService orderService;
    private final AddressService addressService;
    private final CartService cartService;
    @Autowired
    public OrderController(OrderService orderService, AddressService addressService
    , CartService cartService) {
        this.orderService = orderService;
        this.addressService = addressService;
        this.cartService = cartService;
    }

    @GetMapping("/order")
    public String showOrderPage(Model model, HttpSession session){
        User user = (User) session.getAttribute("loggedInUser");
        model.addAttribute("cartNumber", session.getAttribute("cartNumber"));
        model.addAttribute("products", user.getCart().getProducts());
        model.addAttribute("totalPrice", user.getCart().getTotalPrice());

        return "order";
    }
    @PostMapping("/submitOrder")
    public String submitOrder(HttpSession session, @RequestParam("street") String address,
                              @RequestParam("postalCode") int postalCode, @RequestParam("city") String city,
                              @RequestParam("country") String country, Model model){
        User user = (User) session.getAttribute("loggedInUser");
        Address shipmentAddress = addressService.createAddress(address, postalCode, city, country);
        orderService.createOrder(user, 1, user.getCart().getTotalPrice(), 1, 1, 1, shipmentAddress);
        user.getCart().getProducts().clear();
        user.getCart().setQuantity(0);
        user.getCart().setTotalPrice(0);
        model.addAttribute("cartNumber", user.getCart().getQuantity());
        cartService.updateCart(user.getCart());
        return "redirect:/catalog";
    }
}
