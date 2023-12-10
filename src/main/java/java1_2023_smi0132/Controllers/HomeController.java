package java1_2023_smi0132.Controllers;

import java1_2023_smi0132.Models.*;
import java1_2023_smi0132.Services.*;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class HomeController {

    private final UserService userService;
    private final AddressService addressService;
    private final CartService cartService;
    @Autowired
    public HomeController(UserService userService, AddressService addressService, CartService cartService
    ) {
        this.userService = userService;
        this.addressService = addressService;
        this.cartService = cartService;
    }

    @GetMapping("/")
    public String showLogin() {
        System.out.println("Showing login");
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, Model model,
                        HttpSession session) {
        System.out.println("Username: " + username + " Password: " + password);
        if (userService.authenticateUser(username, password)) {
            User user = userService.getUser(username, password);
            System.out.println("User: " + user);
            session.setAttribute("loggedInUser", user);
            System.out.println(user.getCart().getId());
            return "redirect:/catalog";
        }
        model.addAttribute("error", "Invalid username or password");
        System.out.println("Invalid username or password");
        return "login";
    }

    @GetMapping("/register")
    public String showRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
                           @RequestParam("email") String email, @RequestParam("password") String password,
                           @RequestParam("city") String city, @RequestParam("street") String street,
                           @RequestParam("postalCode") int postalCode, @RequestParam("country") String country,
                           Model model) {
        System.out.println("Firstname: " + firstname + " Lastname: " + lastname + " Email: " + email + " Password: " + password);
        if (userService.checkIfUserExists(email)) {
            model.addAttribute("error", "User already exists");
            System.out.println("User already exists");
            return "register";
        }

        Address address = addressService.createAddress(street, postalCode, city, country);
        Cart cart = cartService.createCart();
        User user = userService.createUser(firstname, lastname, email, password, 0, address, cart);

        System.out.println("User created");
        model.addAttribute("success", "User created, please login");
        return "login";
    }
}
