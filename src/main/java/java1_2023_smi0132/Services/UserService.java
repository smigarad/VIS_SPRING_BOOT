package java1_2023_smi0132.Services;

import java1_2023_smi0132.Models.Address;
import java1_2023_smi0132.Models.Cart;
import java1_2023_smi0132.Models.User;
import java1_2023_smi0132.Resources.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            if( user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfUserExists(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

    public User createUser(String firstname, String lastname, String email, String password, int role, Address address, Cart cart) {
        try {
            User user = new User(firstname, lastname, email, password, role, address, cart);
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User getUser(String email, String password) {
        try {
            User user = userRepository.findUserByEmailAndPassword(email, password);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User getUserById(int id) {
        try {
            User user = userRepository.findUserById(id);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
