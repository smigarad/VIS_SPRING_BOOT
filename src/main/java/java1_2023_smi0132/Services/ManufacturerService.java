package java1_2023_smi0132.Services;

import java1_2023_smi0132.Models.Manufacturer;
import java1_2023_smi0132.Resources.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> getAllManufacturers(){
        return manufacturerRepository.findAll();
    }

    public Manufacturer getManufacturerById(int manufacturerId) {
        return manufacturerRepository.findById(manufacturerId).orElse(null);
    }
}
