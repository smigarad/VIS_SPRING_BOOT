package java1_2023_smi0132.Models.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactFormDTO {
    private String firstname;
    private String lastname;
    private String email;
    private String issueType;
    private String description;

    public ContactFormDTO(String firstname, String lastname, String email, String issueType, String description) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.issueType = issueType;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ContactFormDTO{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", issueType='" + issueType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}