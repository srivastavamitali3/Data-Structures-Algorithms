package arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleQuestions {
    public static void main(String[] args) {
        OracleQuestions obj = new OracleQuestions();
       /* System.out.println(angleClock(3, 15));
        System.out.println(addStrings("125", "1256"));
        String[] res = findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"KFC", "Shogun", "Burger King"});
        for (String str : res)
            System.out.println(str);*/

        //System.out.println(obj.myPow(1.00000, 2147483647));
        System.out.println(obj.addBinary
                ("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                        "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }

    public static double angleClock(int hour, int minutes) {
        double h = 360.0 * (hour + minutes / 60.0) / 12;
        double m = (minutes * 360) / 60;
        double angles = Math.abs(h - m);
        return Math.min(angles, 360 - angles);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int x = num1.length() - 1;
        int y = num2.length() - 1;
        while (x >= 0 || y >= 0) {
            int x1 = x >= 0 ? num1.charAt(x) - '0' : 0;
            int x2 = y >= 0 ? num2.charAt(y) - '0' : 0;
            int value = (x1 + x2 + carry) % 10;
            carry = (x1 + x2 + carry) / 10;
            res.append(value);
            x--;
            y--;

        }
        if (carry != 0)
            res.append(carry);
        return res.reverse().toString();
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++)
            map.put(list1[i], i);

        int minIndex = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                int value = j + map.get(list2[j]);
                if (value < minIndex) {
                    result.clear();
                    minIndex = value;
                    result.add(list2[j]);
                } else if (value == minIndex)
                    result.add(list2[j]);
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x == 1)
            return n;
        double power = 0.0;
        if (n > 0) {
            power = getPowerValue(x, n);
        } else {
            power = 1 / getPowerValue(x, n);
        }
        return power;
    }

    private double getPowerValue(double x, int n) {
        double initialValue = x;
        n = Math.abs(n);
        int count = 1;
        while (count != n) {
            x *= initialValue;
            count++;
        }
        return x;
    }

    public String addBinary(String a, String b) {
        /*long a1 = Long.parseLong(a);
        long b1 = Long.parseLong(b);
        int carry = 0;
        String sum = "";
        while (a1 != 0 || b1 != 0) {
            sum += (int) ((a1 % 10 + b1 % 10 + carry) % 2);
            carry = (int) ((a1 % 10 + b1 % 10 + carry) / 2);
            a1 = a1 / 10;
            b1 = b1 / 10;
        }
        if (carry != 0) {
            sum += carry;
        }
        StringBuffer sb = new StringBuffer(sum);
        return ("0".equals(a) && "0".equals(b)) ? "0" : sb.reverse().toString();*/
        // return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
        /*BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);*/

        int m = a.length();
        int n = b.length();
        if (m < 1 || n < 1)
            return null;
        if (m < n)
            return addBinary(b, a);
        int carry = 0;
        int j = n - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = m - 1; i >= 0; i--) {
            if (a.charAt(i) == '1')
                carry++;
            if (j > -1 && b.charAt(j--) == '1')
                carry++;
            if (carry % 2 == 1)
                sb.append("1");
            else
                sb.append("0");
            carry /= 2;
        }
        if (carry == 1)
            sb.append("1");
        sb.reverse();
        return sb.toString();
    }
}

// ""
//""
