package pl.edu.wat.wcy.generator.node;

import pl.edu.wat.wcy.model.node.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class AddressNodeGenerator implements NodeGenerator<Address> {

    private String[] streets = {"Kazury", "Stryjeńskich", "Marszałkowska", "Złota", "Kupiecka", "Długa",
            "Zamkowa", "Komisji Edukacji Narodowej", "Puławska", "Lanciego"};

    @Override
    public List<Address> generate() {
        List<Address> addresses = new ArrayList<>();
        int id = 1;
        String province = "mazowieckie";
        String city = "Warszawa";
        for (int i = 0; i < 3; i++) {
            String street = streets[i];
            int buildingNumber = generateNumber();
            Integer flatNumber = null;
            String zipCode = generateZipCode();
            Address address = new Address(id, province, city, street, buildingNumber, flatNumber, zipCode);
            addresses.add(address);
            id++;
        }
        for (String street : streets) {
            for (int i = 0; i < 50; i++) {
                int buildingNumber = generateNumber();
                Integer flatNumber = generateNumber();
                String zipCode = generateZipCode();
                Address address = new Address(id, province, city, street, buildingNumber, flatNumber, zipCode);
                addresses.add(address);
                id++;
            }
        }
        return addresses;
    }

    private String generateZipCode() {
        String firstPart = String.valueOf(ThreadLocalRandom.current().nextInt(0, 100));
        if (firstPart.length() == 1) firstPart = '0' + firstPart;
        String secondPart = String.valueOf(ThreadLocalRandom.current().nextInt(0, 1000));
        if (secondPart.length() == 1) secondPart = "00" + secondPart;
        else if (secondPart.length() == 2) secondPart = '0' + secondPart;
        return firstPart + "-" + secondPart;
    }

    private int generateNumber() {
        return ThreadLocalRandom.current().nextInt(1, 100);
    }
}
