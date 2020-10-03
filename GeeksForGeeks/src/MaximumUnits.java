package amazonOnlineAssessment;

import java.util.*;

public class MaximumUnits {
    public static void main(String[] args) {
        System.out.println(getMaxUnit(3, Arrays.asList(1,2,3,4), 3, Arrays.asList(3, 2, 1, 5), 4L));
    }

    static long getMaxUnit(int num, List<Integer> boxes, int unitSize, List<Integer> unitsPerBox, long truckSize) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < num; i++) {
            int n = boxes.get(i);
            for (int j = 0; j < n; j++) {
                PQ.add(unitsPerBox.get(i));
                max += PQ.peek();
                if (PQ.size() > truckSize) {
                    max -= PQ.peek();
                    PQ.remove();
                }
            }
        }
        return max;
    }

    /**
     * The general idea is to sort and fill the truck with the highest unit value boxes
     * @param boxes
     * @param unitsPerBox
     * @param truckSize
     * @return
     */
    public static long getMaxUnits1(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        // key: size, value: idx
        // sort by units per box
        // get number of boxes from map based on size
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < boxes.size(); i++) {
            Long boxIdx = boxes.get(i);
            Long size = unitsPerBox.get(i);

            map.put(size, boxIdx);
        }

        Collections.sort(unitsPerBox, Collections.reverseOrder());

        long res = 0;

        for (Long boxSize : unitsPerBox) {
            // greedy fill the truck with the highest value boxes
            Long boxCount = map.get(boxSize);

            if (truckSize < 0) {
                return res;
            }

            // if we have exact space in the truck for all packages of this size
            if (truckSize == boxCount) {
                res += (boxCount * boxSize);
                return res;
            }

            // if space is still left, add to result, and decrement truck size by expected amount
            if (truckSize > boxCount) {
                res += (boxCount * boxSize);
                truckSize -= boxCount;
            } else {
                res += (truckSize * boxSize);
                return res;
            }

        }

        return res;
    }
}
