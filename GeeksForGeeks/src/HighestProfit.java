package amazonOnlineAssessment;

import java.util.*;

/**
 * Amazon Basics has several suppliers for its products. For each of the products,
 * the stock is represented by a list of a number of items for each supplier.
 * As items are purchased, the supplier raises the price by 1 per item purchased.
 * Let's assume Amazon's profit on any single item is the same as the number of items the supplier has left.
 * For example, if a supplier has 4 items, Amazon's profit on the first item sold is 4,
 * then 3, then 2 and the profit of the last one is 1.
 * Given a list where each value in the list is the number of the item at a given
 * supplier and also given the number of items to be ordered, write an algorithm to
 * find the highest profit that can be generated for the given product.
 * <p>
 * Input
 * The input to the function/method consists on three arguments:
 * numSuppliers, an integer representing the number of suppliers;
 * inventory, a list of long integers representing the value of the item at a given supplier;
 * order, a long integer representing the number of items to be ordered.
 * <p>
 * Output
 * Return a long integer representing the highest profit that can be generated for the given product.
 * <p>
 * Constraints
 * 1 <= numSuppliers <= 10^5
 * 1 <= inventory[i] <= 10 ^ 5
 * 0 <= i < numSuppliers
 * 1 <= orders <= sum of inventory
 * <p>
 * Example1
 * <p>
 * Input:
 * <p>
 * numSuppliers = 2
 * <p>
 * inventory = [3,5]
 * <p>
 * order = 6
 * <p>
 * Output:
 * <p>
 * 19
 */
public class HighestProfit {
    public static void main(String[] args) {
        List<Long> inventory = new ArrayList<>();
        inventory.add((long) 2);
        inventory.add((long) 5);
        System.out.println(highestProfit(2, inventory, 4));
        System.out.println(highestProfit1(2, inventory, 4));
    }

    static long highestProfit(int numSuppliers, List<Long> inventory, long order) {
        int profit = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>(inventory.size(), Collections.reverseOrder());
        for (Long i : inventory) {
            pq.add(i);
        }
        while (order != 0 && !pq.isEmpty()) {
            Long top = pq.poll();
            profit += top;
            order--;
            pq.add(top - 1);
        }

        return profit;
    }

    static long highestProfit1(int numSuppliers, List<Long> inventory, long order) {
        int size = inventory.size();
        Long[] list = new Long[size];
        for (int i = 0; i < size; i++)
            list[i] = inventory.get(i);

        Arrays.sort(list, ((o1, o2) -> o2.compareTo(o1)));

        Long[] arr = new Long[size + 1];
        for (int i = 0; i < size; i++)
            arr[i] = list[i];

        arr[size] = Long.valueOf(0);
        int supIndx = 1;
        long maxPro = 0;
        while (order >= 0 && supIndx < arr.length) {
            while (supIndx < arr.length && arr[supIndx - 1] == arr[supIndx])
                supIndx++;
            if (arr[supIndx - 1] == 0)
                break;
            int supMulti = supIndx;
            long diff = arr[supIndx - 1] - arr[supIndx];
            long localCountToOrder = diff * supMulti;
            long localPro = arr[supIndx - 1];
            localCountToOrder = Math.min(order, localCountToOrder);
            order = order - localCountToOrder;
            while (localCountToOrder > 0 && localPro >= arr[supIndx]) {
                long currCountToTake = Math.min(supMulti, localCountToOrder);
                maxPro = maxPro + localPro * currCountToTake;
                localPro--;
                localCountToOrder = localCountToOrder - currCountToTake;
            }
            supIndx++;
        }
        return maxPro;
    }
}
