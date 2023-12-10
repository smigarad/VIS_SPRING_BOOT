package java1_2023_smi0132.Services;

import java1_2023_smi0132.Models.DTO.ContactFormDTO;
import org.springframework.stereotype.Service;
import java.io.*;
@Service
public class FileService {

    public void writeToFile(String filename,ContactFormDTO form) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write(form.getEmail() + ":" + form.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readUserComplaints(String filename, String userEmail) {
        StringBuilder userComplaints = new StringBuilder();
        String emailPrefix = userEmail + ":"; // Email followed by colon

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(emailPrefix)) {
                    // Extract everything after the email and colon
                    String complaint = line.substring(emailPrefix.length()).trim();
                    userComplaints.append(complaint).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error reading file";
        }

        return userComplaints.toString();
    }
}
