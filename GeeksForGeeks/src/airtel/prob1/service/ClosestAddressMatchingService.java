package airtel.prob1.service;

import airtel.prob1.model.Address;

import java.util.Collections;
import java.util.List;

public class ClosestAddressMatchingService {

    private List<Address> arr;

    public ClosestAddressMatchingService(List<Address> arr) {
        this.arr = arr;
        Collections.sort(arr);
    }

    public Address findClosestMatchingAddress(Address target) {
        int n = arr.size();

        // Corner cases
        if (target.compareTo(arr.get(0)) <= 0)
            return arr.get(0);
        if (target.compareTo(arr.get(n - 1)) >= 0)
            return arr.get(n - 1);

        // Doing binary search
        int i = 0, j = n, mid = 0;
        while (i < j) {
            mid = (i + j) / 2;

            if (arr.get(mid).equals(target))
                return arr.get(mid);

            /* If target is less than array element,
               then search in left */
            if (target.compareTo(arr.get(mid)) < 0) {

                // If target is greater than previous
                // to mid, return closest of two
                if (mid > 0 && target.compareTo(arr.get(mid - 1)) > 0)
                    return getClosest(arr.get(mid - 1),
                            arr.get(mid), target);

                /* Repeat for left half */
                j = mid;
            }

            // If target is greater than mid
            else {
                if (mid < n - 1 && target.compareTo(arr.get(mid + 1)) < 0)
                    return getClosest(arr.get(mid),
                            arr.get(mid + 1), target);
                i = mid + 1; // update i
            }
        }

        // Only single element left after search
        return arr.get(mid);
    }

    private static Address getClosest(Address val1, Address val2, Address target) {
        if (target.compareTo(val1) >= val2.compareTo(target))
            return val2;
        else
            return val1;
    }
}
