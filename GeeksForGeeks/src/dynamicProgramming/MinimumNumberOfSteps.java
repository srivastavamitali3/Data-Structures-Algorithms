package dynamicProgramming;

import arrays.SumOfTwoLargeNumbers;

import java.math.BigInteger;
import java.util.Scanner;

public class MinimumNumberOfSteps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MinimumNumberOfSteps obj = new MinimumNumberOfSteps();
        int t = sc.nextInt();
        while (t-- > 0) {
            int destination = sc.nextInt();
            System.out.println(obj.minimumNoOfSteps(destination));
        }
    }

    private int minimumNoOfSteps(int destination) {
        destination = Math.abs(destination);

        int sum = 0, steps = 0;
        while (sum < destination || (sum - destination) % 2 != 0) {
            steps++;
            sum += steps;
        }
        return steps;
    }
}

/*
Test Case
422- 30
493- 32
*/
