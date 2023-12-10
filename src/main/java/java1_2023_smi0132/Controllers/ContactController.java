package java1_2023_smi0132.Controllers;

import java1_2023_smi0132.Models.DTO.ContactFormDTO;
import java1_2023_smi0132.Models.User;
import java1_2023_smi0132.Services.FileService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    private final FileService fileService;

    @Autowired
    public ContactController(FileService fileService) {
        this.fileService = fileService;
    }
    @GetMapping("/contact")
    public String showContactForm(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            model.addAttribute("loggedInUser", loggedInUser);
            model.addAttribute("cartNumber", loggedInUser.getCart().getQuantity());
        }
        return "contact";
    }

    @PostMapping("/contactSubmit")
    public String submitContactForm(@RequestParam("firstname") String firstname,
                                    @RequestParam("lastname") String lastname,
                                    @RequestParam("email") String email,
                                    @RequestParam("issueType") String issueType,
                                    @RequestParam("description") String description) {
        ContactFormDTO form = new ContactFormDTO(firstname, lastname, email, issueType, description);
        fileService.writeToFile("complaints.txt", form);

        return "redirect:/catalog";
    }

    @GetMapping("/viewComplaints")
    public String viewComplaints(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        String complaints = fileService.readUserComplaints("complaints.txt", loggedInUser.getEmail());

        model.addAttribute("complaints", complaints);
        model.addAttribute("cartNumber", loggedInUser.getCart().getQuantity());
        return "complaints";
    }
}
