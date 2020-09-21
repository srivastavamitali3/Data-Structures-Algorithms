package airtel.prob1.comparator;

import airtel.prob1.model.Address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {

    @Override
    public int compare(Address o1, Address o2) {
        int i = o1.getCity().compareTo(o2.getCity());
        if (i != 0)
            return i;
        i = o1.getLocality().compareTo(o2.getLocality());
        if (i != 0)
            return i;
        return o1.getPlotNo().compareTo(o2.getPlotNo());
    }
}
