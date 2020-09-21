package airtel.prob1.model;

public class Address implements Comparable<Address> {

    String plotNo;
    String locality;
    String city;


    public Address(String plotNo, String locality, String city) {
        this.plotNo = plotNo;
        this.locality = locality;
        this.city = city;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "plotNo='" + plotNo + '\'' +
                ", locality='" + locality + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public int compareTo(Address o) {
        int i = city.compareTo(o.city);
        if (i != 0)
            return i;
        i = locality.compareTo(o.locality);
        if (i != 0)
            return i;
        return plotNo.compareTo(o.plotNo);
    }
}
