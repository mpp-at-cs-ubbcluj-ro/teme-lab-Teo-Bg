import org.example.Car;
import org.example.CarRepository;
import org.example.CarsDBRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MainBD {
    public static void main(String[] args) {

        Properties props=new Properties();
        try {
            props.load(new FileReader("C:\\Facultate\\Anul 2\\Semestrul 2\\Medii de Proiectare si Programare\\teme-lab-Teo-Bg\\AssigmentLab3\\db.config"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
        }
        System.out.println(props);

        CarRepository carRepo=new CarsDBRepository(props);
        carRepo.add(new Car("Tesla","Model S", 2019));
        System.out.println("Toate masinile din db");
        for(Car car:carRepo.findAll())
            System.out.println(car);
       String manufacturer="Tesla";
        System.out.println("Masinile produse de "+manufacturer);
        for(Car car:carRepo.findByManufacturer(manufacturer))
            System.out.println(car);

    }
}
