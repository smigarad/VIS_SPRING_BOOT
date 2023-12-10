package java1_2023_smi0132.Services;

import java1_2023_smi0132.Models.Cart;
import java1_2023_smi0132.Models.Product;
import java1_2023_smi0132.Resources.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart(){
        try {
            Cart cart = new Cart(0,0);
            cartRepository.save(cart);
            return cart;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Cart updateCart(Cart cart){
        try {
            cartRepository.save(cart);
            return cart;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Transactional
    public void addProductToCart(int cart_id, int quantity, Product product){
        Cart cart = cartRepository.findById(cart_id).orElse(null);
        try {
            assert cart != null;

            boolean productExists = cart.getProducts().stream()
                    .anyMatch(p -> p.getId() == product.getId());
            if(!productExists){
                cart.getProducts().add(product);
                cart.setQuantity(cart.getProducts().size());
                cart.setTotalPrice(cart.getTotalPrice() + product.getPrice());
                cartRepository.save(cart);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    public Cart getCartById(int id){
        return cartRepository.findById(id).orElse(null);
    }

    public void removeProductFromCart(int cart_id, int product_id){
        Cart cart = cartRepository.findById(cart_id).orElse(null);
        try {
            assert cart != null;
            List<Product> products = cart.getProducts();
            for (Product product : products) {
                if (product.getId() == product_id) {
                    cart.setTotalPrice(cart.getTotalPrice() - product.getPrice());
                    cart.setQuantity(cart.getQuantity() - 1);
                    products.remove(product);
                    cartRepository.save(cart);
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void flushCart(int cart_id){
        Cart cart = cartRepository.findById(cart_id).orElse(null);
        try {
            assert cart != null;
            cart.setTotalPrice(0);
            cart.setQuantity(0);
            cart.getProducts().clear();
            cartRepository.save(cart);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
