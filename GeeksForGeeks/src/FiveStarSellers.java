package amazonOnlineAssessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given the number of five-star and total reviews for each product a company sells,
 * as well as the threshold percentage, what is the minimum number of additional five-star reviews
 * the company needs to become five star seller.
 * For ex, there are 3 products (n=3) with productRatings =[[4,4],[1,2],[3,6]], percentage rating threshold = 77.
 * [1,2] indicates => [1 (five star reviews) ,2 (total reviews)].
 * We need to get the seller reach the threshold with minimum number of additional five star reviews.
 *
 * Before we add more five star reviews, the percentage for this seller is ((4/4) + (1/2) + (3/6))/3 = 66.66%
 * If we add a five star review to 2nd product, ((4/4) + (2/3) + (3/6))/3 = 72.22%
 * If we add another five star review to 2nd product, ((4/4) + (3/4) + (3/6))/3 = 75%
 * If we add a five star review to 3rd product, ((4/4) + (3/4) + (4/7))/3 = 77.38%
 * At this point, 77% (threshold) is met. Therefore, answer is 3 (because that is the minimum five
 * star reviews we need to add, to get the seller reach the threshold).
 *
 * public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold){
 * }
 * Constraints:
 * 1<= productRatings.size() <=200
 * In product ratings, [fivestar, total], fivestar <=100, total<=100
 * 1<=ratingsThreshold< 100
 * productRatings contains only non negative integers.
 */
public class FiveStarSellers {
    public int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold) {
        int num = 0;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> diff(l2) - diff(l1)); // max-heap.
        for (List<Integer> rating : productRatings) pq.offer(rating); // initialize PriorityQueue.
        double curRating = 0;
        for (List<Integer> rating : productRatings)
            curRating += 100.0 * rating.get(0) / rating.get(1); // initialize curRating.
        while (curRating < ratingsThreshold * productRatings.size()) {
            num++;
            List<Integer> rating = pq.poll();
            List<Integer> newRating = Arrays.asList(rating.get(0) + 1, rating.get(1) + 1);
            curRating = curRating - 100.0 * rating.get(0) / rating.get(1) + 100.0 * newRating.get(0) / newRating.get(1); // keep updating the rating.
            pq.offer(newRating);
        }
        return num;
    }

    // the diff between the current product rating and the product added one more five-star rating.
    private int diff(List<Integer> p) {
        double currRating = 100.0 * p.get(0) / p.get(1);
        double newRating = 100.0 * (p.get(0) + 1) / (p.get(1) + 1);
        return (int) (newRating - currRating);
    }

    public static void main(String[] args) {
        List<List<Integer>> ratings = new ArrayList() {
            {
                add(Arrays.asList(4, 4));
                add(Arrays.asList(1, 2));
                add(Arrays.asList(3, 6));
            }
        };
        int threshold = 77;
        FiveStarSellers s = new FiveStarSellers();
        System.out.println(s.fiveStarReviews(ratings, threshold));
    }
}
//Java PriorityQueue solution, the idea is same as other guys' solutions.
// For each product, we want to calculate the biggest percentage jump if we add one more five-start to it.
// So we can use a max-heap so the head of the heap is current biggest jump product.
// Then we create a new rating based on this head, add one more five-start to this new rating and
// push to the heap again. Reminder to keep track the updated rating until we are above the threshold