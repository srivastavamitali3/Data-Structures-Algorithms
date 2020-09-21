package arrays;

import java.util.Scanner;

/*Test Case
* 1
1abc2x30yz67
*/
public class SumOfNumbersInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SumOfNumbersInString obj = new SumOfNumbersInString();
        int t = sc.nextInt();
        while (t-- > 0) {
            String str = sc.next();
            System.out.println(obj.calcSum(str));
        }
    }

    private int calcSum(String str) {
        String[] s = str.split("\\D");
        int sum = 0;
        for (int i = 0; i < s.length; i++)
            if (!s[i].isEmpty())
                sum += Integer.parseInt(s[i]);
        return sum;
    }
}
