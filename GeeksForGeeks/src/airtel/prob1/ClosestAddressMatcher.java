package airtel.prob1;

import airtel.prob1.model.Address;
import airtel.prob1.service.ClosestAddressMatchingService;

import java.util.ArrayList;
import java.util.List;

public class ClosestAddressMatcher {

    public static void main(String[] args) {
        Address address1 = new Address("6480", "Sector C6", "Vasant Kunj");
        Address address2 = new Address("Plot 16", "Udyog Vihar Phase - 4", "Gurgaon");
        Address address3 = new Address("8231", "Sector C8", "Vasant Kunj");
        Address address4 = new Address("6280", "Sector C6", "Vasant Kunj");

        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        addressList.add(address3);
        addressList.add(address4);

        Address input1 = new Address("6279", "Sector C6", "Vasant Kunj");
        Address input2 = new Address("Plot 18", "Udyog Vihar Phase - 4", "Gurgaon");

        ClosestAddressMatchingService service = new ClosestAddressMatchingService(addressList);

        System.out.println(service.findClosestMatchingAddress(input1));
        System.out.println(service.findClosestMatchingAddress(input2));

    }
}
