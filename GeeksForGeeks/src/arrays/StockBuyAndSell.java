package arrays;

/*
The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. Since no body has mentioned
 this so far, I thought it's a good thing for everybody to know.
All the straight forward solution should work, but if the interviewer twists the question slightly by giving the
difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.
Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array,
and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.

A more clear explanation on why sum of subarray works.:

Suppose we have original array:
[a0, a1, a2, a3, a4, a5, a6]

what we are given here(or we calculate ourselves) is:
[b0, b1, b2, b3, b4, b5, b6]

where,
b[i] = 0, when i == 0
b[i] = a[i] - a[i - 1], when i != 0

suppose if a2 and a6 are the points that give us the max difference (a2 < a6)
then in our given array, we need to find the sum of sub array from b3 to b6.

b3 = a3 - a2
b4 = a4 - a3
b5 = a5 - a4
b6 = a6 - a5

adding all these, all the middle terms will cancel out except two
i.e.

b3 + b4 + b5 + b6 = a6 - a2

a6 - a2 is the required solution.

so we need to find the largest sub array sum to get the most profit

 */
public class StockBuyAndSell {
    public static void main(String[] args) {
        StockBuyAndSell obj = new StockBuyAndSell();
        int[] arr = new int[]{7,6,4,3,1};
        System.out.println(obj.maxProfit2(arr));
    }

    public int maxProfit(int[] prices) {
        long max_so_far = 0, max_curr = Integer.MIN_VALUE, prevNoStock = 0;
        for (int price : prices) {
            long tmp = max_so_far;
            max_so_far = Math.max(max_so_far, max_curr + price);
            max_curr = Math.max(max_curr, prevNoStock - price);
            prevNoStock = tmp;
        }
        return (int)max_so_far;
    }

    public int maxProfit1(int[] prices) {
        //return maxProfit(prices, 0, prices.length - 1);
        int len=prices.length;
        if(len<=1)
            return 0;

        if(len==2 && prices[1]>prices[0])
            return prices[1]-prices[0];
        else if(len==2 && prices[0]> prices[1])
            return 0;

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] -  prices[1]);

        for(int i=2; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }

        return dp[len-1][0];
    }

    static int maxProfit(int price[], int start, int end) {

        // If the stocks can't be bought
        if (end <= start)
            return 0;
        // Initialise the profit
        int profit = 0;
        // The day at which the stock
        // must be bought
        for (int i = start; i < end; i++) {
            // The day at which the
            // stock must be sold
            for (int j = i + 1; j <= end; j++) {
                // If byuing the stock at ith day and
                // selling it at jth day is profitable
                if (price[j] > price[i]) {
                    // Update the current profit
                    int curr_profit = price[j] - price[i]
                            + maxProfit(price, start, i - 1)
                            + maxProfit(price, j + 1, end);
                    // Update the maximum profit so far
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit - 1;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length == 0)
            return 0;

        int minPrice = prices[0], maxProfit = 0;
        for(int price : prices){
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice,price);
        }

        return maxProfit;
    }
}
