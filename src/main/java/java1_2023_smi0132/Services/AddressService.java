package java1_2023_smi0132.Services;

import java1_2023_smi0132.Models.Address;
import java1_2023_smi0132.Resources.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(String street, int postalCode, String city, String country) {
        try {
            Address address = new Address(street,city,country,postalCode);
            addressRepository.save(address);
            return address;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
