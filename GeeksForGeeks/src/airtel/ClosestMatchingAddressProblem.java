package airtel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class MasterList {
    String houseNo = "";
    String sectorNo = "";
    String city = "";

    public MasterList(String houseNo, String sectorNo, String city) {
        this.houseNo = houseNo;
        this.sectorNo = sectorNo;
        this.city = city;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getSectorNo() {
        return sectorNo;
    }

    public void setSectorNo(String sectorNo) {
        this.sectorNo = sectorNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "airtel.MasterList{" +
                "addressLine1='" + houseNo + '\'' +
                ", addressLine2='" + sectorNo + '\'' +
                ", addressLine3='" + city + '\'' +
                '}';
    }
}

class AddressSortingComparator implements Comparator<MasterList> {

    @Override
    public int compare(MasterList o1, MasterList o2) {
        int compareCity = o1.getCity()
                .compareTo(o2.getCity());
        int compareSector = o1.getSectorNo().compareTo(o2.getSectorNo());
        int compareHouse = o1.getHouseNo().compareTo(o2.getHouseNo());

        if (compareCity == 0) {
            return ((compareCity == 0) ? compareSector : compareHouse);
        } else {
            return compareCity;
        }
    }
}

class SearchAddress {
    String houseNo = "";
    String sectorNo = "";
    String city = "";

    public SearchAddress(String houseNo, String sectorNo, String city) {
        this.houseNo = houseNo;
        this.sectorNo = sectorNo;
        this.city = city;
    }
}

public class ClosestMatchingAddressProblem {
    public static void main(String[] args) throws IOException {
        ArrayList<MasterList> masterList = getAddressMasterList();
        Collections.sort(masterList, new AddressSortingComparator());

        ArrayList<SearchAddress> addressList = getDummyList();

        String nearestAddress = findNearestAddress(addressList, masterList);

        System.out.println(nearestAddress);

    }

    private static String findNearestAddress(ArrayList<SearchAddress> searchAddress, ArrayList<MasterList> masterList) {

        return null;
    }

    private static ArrayList<MasterList> getAddressMasterList() {
        ArrayList<MasterList> masterList = new ArrayList<>();
        masterList.add(new MasterList("6480", "Sector C6", "Vasant Kunj"));
        masterList.add(new MasterList("Plot 16", "Udyog Vihar Phase-4", "Gurgaon"));
        masterList.add(new MasterList("8231", "Sector C8", "Vasant Kunj"));
        masterList.add(new MasterList("C-6/6280", " ", "Vasant Kunj"));
        return masterList;
    }

    private static ArrayList<SearchAddress> getDummyList() {
        ArrayList<SearchAddress> dummyList = new ArrayList<>();
        dummyList.add(new SearchAddress("6480", "Sector C6", "Vasant Kunj"));
        dummyList.add(new SearchAddress("Plot 16", "Udyog Vihar Phase-4", "Gurgaon"));
        dummyList.add(new SearchAddress("8231", "Sector C8", "Vasant Kunj"));
        dummyList.add(new SearchAddress("C-6/6280", " ", "Vasant Kunj"));
        return dummyList;
    }
}
